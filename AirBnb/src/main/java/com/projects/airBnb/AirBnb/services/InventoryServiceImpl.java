package com.projects.airBnb.AirBnb.services;

import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.dto.HotelBrowseRequest;
import com.projects.airBnb.AirBnb.dto.HotelPriceDto;
import com.projects.airBnb.AirBnb.entities.Hotel;
import com.projects.airBnb.AirBnb.entities.Inventory;
import com.projects.airBnb.AirBnb.entities.Room;
import com.projects.airBnb.AirBnb.repositories.HotelMinPriceRepository;
import com.projects.airBnb.AirBnb.repositories.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@RequiredArgsConstructor

public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
	private final HotelMinPriceRepository hotelMinPriceRepository;

    @Override
    public void initializeRoomForAYear(Room room) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);
        for(; !today.isAfter(endDate);today = today.plusDays(1)){
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .reservedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBasePrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }
    }

    @Override
    public void deleteAllInventories(Room room) {
        log.info("Deleting the inventories of room with id: {}", room.getId());
        inventoryRepository.deleteByRoom(room);

    }

    @Override
    public Page<HotelPriceDto> searchHotels(HotelBrowseRequest hotelBrowseRequest) {
        log.info("Searching hotels for {} city, from {} to {}", hotelBrowseRequest.getCity(), hotelBrowseRequest.getStartDate(), hotelBrowseRequest.getEndDate());
        Pageable pageable = PageRequest.of(hotelBrowseRequest.getPage(), hotelBrowseRequest.getSize());
        long dateCount =
                ChronoUnit.DAYS.between(hotelBrowseRequest.getStartDate(), hotelBrowseRequest.getEndDate()) + 1;

        // business logic - 90 days
        Page<HotelPriceDto> hotelPage =  hotelMinPriceRepository.findHotelsWithAvailableInventory(hotelBrowseRequest.getCity(),
                hotelBrowseRequest.getStartDate(), hotelBrowseRequest.getEndDate(), hotelBrowseRequest.getRoomsCount(),
                dateCount, pageable);

        return hotelPage;
    }
}
