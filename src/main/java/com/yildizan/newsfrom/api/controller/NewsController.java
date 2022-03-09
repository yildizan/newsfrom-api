package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.dto.NewsDto;
import com.yildizan.newsfrom.api.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping(path = "/news/{id}")
    public NewsDto find(@PathVariable Integer id) {
        return newsService.findById(id);
    }

}
