package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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
