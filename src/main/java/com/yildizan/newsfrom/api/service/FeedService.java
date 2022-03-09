package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.dto.FeedDto;
import com.yildizan.newsfrom.api.entity.BaseNews;
import com.yildizan.newsfrom.api.entity.Feed;
import com.yildizan.newsfrom.api.mapper.DtoMapper;
import com.yildizan.newsfrom.api.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final DtoMapper mapper;
    private final FeedRepository feedRepository;

    public List<FeedDto> findHavingNews() {
        List<Feed> feeds = feedRepository.findHavingNews();
        for (Feed feed : feeds) {
            feed.getNewsList().removeIf(BaseNews::isNotLocated);
        }
        return mapper.toFeedDtos(feeds);
    }

}
