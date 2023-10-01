package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.dto.LocationDto;
import com.yildizan.newsfrom.api.entity.Location;
import com.yildizan.newsfrom.api.entity.LocationType;
import com.yildizan.newsfrom.api.mapper.DtoMapper;
import com.yildizan.newsfrom.api.repository.LocationRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final DtoMapper mapper;
    private final LocationRepository locationRepository;

    public List<LocationDto> findCountries() {
        List<Location> countries = locationRepository.findByLocationType(LocationType.COUNTRY);
        return mapper.toLocationDtos(countries);
    }

}
