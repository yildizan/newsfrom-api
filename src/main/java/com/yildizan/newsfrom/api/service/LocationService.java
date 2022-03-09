package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.dto.LocationDto;
import com.yildizan.newsfrom.api.entity.LocationType;
import com.yildizan.newsfrom.api.mapper.DtoMapper;
import com.yildizan.newsfrom.api.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final DtoMapper mapper;
    private final LocationRepository locationRepository;

    public List<LocationDto> findCountries() {
        return mapper.toLocationDtos(locationRepository.findByLocationType(LocationType.COUNTRY));
    }

}
