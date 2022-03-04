package com.yildizan.newsfrom.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yildizan.newsfrom.api.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query("select l " +
            "from Location l " +
            "where l.locationTypeId = 1")
    Iterable<Location> findCountries();

}
