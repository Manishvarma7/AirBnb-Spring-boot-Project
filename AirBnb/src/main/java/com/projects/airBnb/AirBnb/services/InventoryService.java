package com.projects.airBnb.AirBnb.services;

import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.dto.HotelBrowseRequest;
import com.projects.airBnb.AirBnb.dto.HotelPriceDto;
import com.projects.airBnb.AirBnb.entities.Room;
import org.springframework.data.domain.Page;

public interface InventoryService  {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelBrowseRequest hotelBrowseRequest);
}
