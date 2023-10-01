package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.Feed;

import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends ReadOnlyRepository<Feed, Integer> {

}
