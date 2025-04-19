package com.projects.airBnb.AirBnb.services;

import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.entities.Hotel;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelbyId(Long id) ;
}
