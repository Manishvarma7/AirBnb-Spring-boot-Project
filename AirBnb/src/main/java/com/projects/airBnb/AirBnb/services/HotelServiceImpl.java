package com.projects.airBnb.AirBnb.services;


import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.entities.Hotel;
import com.projects.airBnb.AirBnb.exceptions.ResourceNotFoundException;
import com.projects.airBnb.AirBnb.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{


    //RequiredArgsConstructor is going to create a constructor with required arguments
    // so this is a constructor dependency injection
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("creating a new hotel with  name : {}",hotelDto.getName());
        Hotel hotel= modelMapper.map(hotelDto,Hotel.class); //Here we are mapping all the fields of Hotel DTo
        // to the Hotel entity that is hotel.class and converts all the fields from hotel DTO to hotel entity
        hotel.setActive(false); // initially the hotel is inactive so that it is not available directly when it is created
        hotel= (Hotel) hotelRepository.save(hotel);
        log.info("created a new hotel with ID : {}",hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelbyId(Long id) {
        log.info("getting the hotel with ID : {}",id);
        Hotel hotel= (Hotel) hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with ID:" + id));
        return modelMapper.map(hotel, HotelDto.class);
    }



}
