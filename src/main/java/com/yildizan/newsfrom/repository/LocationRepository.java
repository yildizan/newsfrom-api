package com.yildizan.newsfrom.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yildizan.newsfrom.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query("select l " +
            "from Location l " +
            "where l.locationTypeId = 1")
    Iterable<Location> findCountries();

}
