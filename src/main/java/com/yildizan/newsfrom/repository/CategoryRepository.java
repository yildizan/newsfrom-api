package com.yildizan.newsfrom.repository;

import org.springframework.data.repository.CrudRepository;

import com.yildizan.newsfrom.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
