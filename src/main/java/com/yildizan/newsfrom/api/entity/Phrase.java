package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Phrase {

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

}
