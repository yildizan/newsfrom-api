package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.Location;
import com.yildizan.newsfrom.api.entity.LocationType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends ReadOnlyRepository<Location, Integer> {

    List<Location> findByLocationType(LocationType locationType);

}
