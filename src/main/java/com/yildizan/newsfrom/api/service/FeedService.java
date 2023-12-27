package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.dto.FeedDto;
import com.yildizan.newsfrom.api.entity.Feed;
import com.yildizan.newsfrom.api.mapper.DtoMapper;
import com.yildizan.newsfrom.api.repository.FeedRepository;

import java.util.LinkedList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final DtoMapper mapper;
    private final FeedRepository feedRepository;

    @Cacheable(value = "feeds")
    public List<FeedDto> getFeeds() {
        List<Feed> allFeeds = feedRepository.findAll();
        List<Feed> feeds = new LinkedList<>();

        for (Feed feed : allFeeds) {
            if (feed.hasLocatedNews()) {
                feed.filterNews();
                feeds.add(feed);
            }
        }

        return mapper.toFeedDtos(feeds);
    }

    @CacheEvict(value = "feeds", allEntries = true)
    public void evict() { }

}
