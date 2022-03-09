package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
