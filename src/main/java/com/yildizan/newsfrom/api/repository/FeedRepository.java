package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends org.springframework.data.repository.Repository<Feed, Integer> {

    @Query("select f from Feed f where f.newsList is not empty")
    List<Feed> findHavingNews();

}
