package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.News;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends ReadOnlyRepository<News, Integer> {

}
