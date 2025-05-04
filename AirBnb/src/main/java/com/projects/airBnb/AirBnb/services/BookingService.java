package com.projects.airBnb.AirBnb.services;



import com.projects.airBnb.AirBnb.dto.BookingDto;
import com.projects.airBnb.AirBnb.dto.BookingRequest;
import com.projects.airBnb.AirBnb.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
