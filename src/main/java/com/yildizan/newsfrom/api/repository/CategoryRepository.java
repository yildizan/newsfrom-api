package com.yildizan.newsfrom.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.yildizan.newsfrom.api.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
