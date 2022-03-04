package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.model.Location;
import com.yildizan.newsfrom.api.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/location")
public class LocationController {

    private static final Logger log = LoggerFactory.getLogger("error");

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(path="/country")
    public List<Location> country() {
        List<Location> result = new ArrayList<>();

        for(var location : locationRepository.findCountries()) {
            Location model = new Location();
            model.setId(location.getId());
            model.setName(location.getName());
            model.setLatitude(location.getLatitude());
            model.setLongitude(location.getLongitude());
            result.add(model);
        }

        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handle(Exception e) {
        log.error("exception: ", e);
    }
}
