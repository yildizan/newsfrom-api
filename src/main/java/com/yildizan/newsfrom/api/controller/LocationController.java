package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.dto.LocationDto;
import com.yildizan.newsfrom.api.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping(path = "/location/country")
    public List<LocationDto> findCountries() {
        return locationService.findCountries();
    }

}
