package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Data
@Entity
public class Location {

	@Id
	private Integer id;

	private String name;
	private Double latitude;
	private Double longitude;

	@Enumerated(EnumType.STRING)
	private LocationType locationType;

}
