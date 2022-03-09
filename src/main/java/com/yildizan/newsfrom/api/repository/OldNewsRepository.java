package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.OldNews;
import org.springframework.stereotype.Repository;

@Repository
public interface OldNewsRepository extends ReadOnlyRepository<OldNews, Integer> {

}
