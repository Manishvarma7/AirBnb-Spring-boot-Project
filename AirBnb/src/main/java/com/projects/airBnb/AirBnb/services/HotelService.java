package com.projects.airBnb.AirBnb.services;

import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.dto.HotelInfoDto;
import com.projects.airBnb.AirBnb.entities.Hotel;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelbyId(Long id) ;

    HotelDto updateHotelById(Long id , HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activeHotelById(Long id);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
