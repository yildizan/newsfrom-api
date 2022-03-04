package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.entity.Feed;
import com.yildizan.newsfrom.api.entity.Location;
import com.yildizan.newsfrom.api.entity.OldNews;
import com.yildizan.newsfrom.api.model.Filter;
import com.yildizan.newsfrom.api.model.News;
import com.yildizan.newsfrom.api.repository.NewsRepository;
import com.yildizan.newsfrom.api.repository.OldNewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/news")
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger("error");

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private OldNewsRepository oldNewsRepository;

    @GetMapping(path="/get/{id}")
    public News get(@PathVariable int id) {
        Object news = newsRepository.getById(id);
        news = news == null ? oldNewsRepository.getById(id) : news;
        return news == null ? null : assign((Object[]) news);
    }

    @GetMapping(path="/list")
    public List<News> list() {
        return assignList(newsRepository.findLocated());
    }

    @PostMapping(path="/list")
    public List<News> list(@RequestBody Filter filter) {
        return assignList(newsRepository.findLocatedFiltered(
                filter.getCategories(), filter.getLanguages(), filter.getPublishers()));
    }

    private List<News> assignList(List<Object[]> list) {
        List<News> result = new ArrayList<>();

        for(var obj : list) {
            result.add(assign(obj));
        }

        return result;
    }

    private News assign(Object[] obj) {
        News model = new News();
        // from news
        try {
            var news = (com.yildizan.newsfrom.api.entity.News) obj[0];
            model.setId(news.getId());
            model.setTitle(news.getTitle());
            model.setDescription(news.getDescription());
            model.setLink(news.getLink());
            model.setThumbnailUrl(news.getThumbnailUrl());
            model.setProcessTime(news.getProcessTime());
            model.setPublishDate(news.getPublishDate());
            model.setVersionNo(news.getVersionNo());
        }
        catch(ClassCastException e) {
            var news = (OldNews) obj[0];
            model.setId(news.getId());
            model.setTitle(news.getTitle());
            model.setDescription(news.getDescription());
            model.setLink(news.getLink());
            model.setThumbnailUrl(news.getThumbnailUrl());
            model.setProcessTime(news.getProcessTime());
            model.setPublishDate(news.getPublishDate());
            model.setVersionNo(news.getVersionNo());
        }
        // from feed
        var feed = (Feed) obj[1];
        model.setCategoryId(feed.getCategoryId());
        model.setLanguageId(feed.getLanguageId());
        model.setPublisherId(feed.getPublisherId());
        // from location
        var location = (Location) obj[2];
        model.setLatitude(location.getLatitude());
        model.setLongitude(location.getLongitude());
        model.setLocation(location.getName());
        return model;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handle(Exception e) {
        log.error("exception: ", e);
    }
}
