package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.dto.FeedDto;
import com.yildizan.newsfrom.api.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping(path = "/feed")
    public List<FeedDto> fetch() {
        return feedService.findHavingNews();
    }

}
