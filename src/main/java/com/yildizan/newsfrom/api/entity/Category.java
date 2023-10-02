package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Data
@Entity
public class Category {

	@Id
	private Integer id;
	
	private String name;
	private String background;
	private String icon;
	private Integer displayOrder;

}
