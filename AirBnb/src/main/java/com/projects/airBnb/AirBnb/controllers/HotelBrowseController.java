package com.projects.airBnb.AirBnb.controllers;


import com.projects.airBnb.AirBnb.dto.HotelBrowseRequest;
import com.projects.airBnb.AirBnb.dto.HotelInfoDto;
import com.projects.airBnb.AirBnb.dto.HotelPriceDto;
import com.projects.airBnb.AirBnb.services.HotelService;
import com.projects.airBnb.AirBnb.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelBrowseRequest hotelBrowseRequest) {

        var page = inventoryService.searchHotels(hotelBrowseRequest);
        return (ResponseEntity<Page<HotelPriceDto>>) ResponseEntity.ok();
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }



}
