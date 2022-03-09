package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Publisher {

	@Id
	private Integer id;

	private String name;

}
