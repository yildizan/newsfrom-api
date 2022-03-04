package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.OldNews;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OldNewsRepository extends CrudRepository<OldNews, Integer> {

    @Query("select n, f, l " +
            "from OldNews n, Phrase p, Feed f, Location l " +
            "where n.topPhraseId = p.id " +
            "and n.feedId = f.id " +
            "and p.locationId = l.id " +
            "and n.id = :id")
    Object getById(int id);
}
