package com.projects.airBnb.AirBnb.controllers;

import com.projects.airBnb.AirBnb.dto.HotelDto;
import com.projects.airBnb.AirBnb.services.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;


    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto){
        log.info("attempting to create a new hotel with name:"+ hotelDto.getName());
        HotelDto hotelDto1 = hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotelDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<HotelDto> getHotelbyID(@PathVariable Long id) throws Throwable {
        HotelDto hotelDto1 = hotelService.getHotelbyId(id);
        return ResponseEntity.ok(hotelDto1);
    }
}
