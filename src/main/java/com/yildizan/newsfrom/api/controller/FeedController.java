package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.dto.FeedDto;
import com.yildizan.newsfrom.api.service.FeedService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping(path = "/feed")
    public List<FeedDto> fetch() {
        return feedService.getFeeds();
    }

    @PostMapping(path = "/feed/evict")
    public ResponseEntity<Void> evict(@RequestHeader(value = "X-Api-Key", required = false) String key) {
        try {
            feedService.evict(key);
            return ResponseEntity.ok().build();
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
