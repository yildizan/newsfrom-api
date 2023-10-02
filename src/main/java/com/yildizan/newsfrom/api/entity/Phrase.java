package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class Phrase {

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

}
