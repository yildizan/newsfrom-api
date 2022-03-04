package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.model.Category;
import com.yildizan.newsfrom.api.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/category")
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger("error");

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping(path="/list")
	public List<Category> list() {
		List<Category> result = new ArrayList<>();

		for(var category : categoryRepository.findAll()) {
			Category model = new Category();
			model.setId(category.getId());
			model.setName(category.getName());
			model.setBackground(category.getBackground());
			model.setIcon(category.getIcon());
			model.setDisplayOrder(category.getDisplayOrder());
			result.add(model);
		}

		return result;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handle(Exception e) {
		log.error("exception: ", e);
	}
}
