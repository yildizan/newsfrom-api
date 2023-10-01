package com.yildizan.newsfrom.api.service;

import com.yildizan.newsfrom.api.dto.NewsDto;
import com.yildizan.newsfrom.api.entity.BaseNews;
import com.yildizan.newsfrom.api.mapper.DtoMapper;
import com.yildizan.newsfrom.api.repository.NewsRepository;
import com.yildizan.newsfrom.api.repository.OldNewsRepository;

import java.util.Objects;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final DtoMapper mapper;
    private final NewsRepository newsRepository;
    private final OldNewsRepository oldNewsRepository;

    @Cacheable(value = "feeds", key = "#id", unless = "#result == null")
    public NewsDto findById(Integer id) {
        BaseNews news = newsRepository.findById(id).orElse(null);
        if (Objects.isNull(news)) {
            news = oldNewsRepository.findById(id).orElse(null);
        }
        return mapper.toRichNewsDto(news);
    }

}
