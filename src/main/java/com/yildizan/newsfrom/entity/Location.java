package com.yildizan.newsfrom.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yildizan.newsfrom.utility.TimeConverter;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer parentId;
	private Integer locationTypeId;
	private String name;
	private Double latitude;
	private Double longitude;

	@Column(name = "last_dml_time", insertable = false)
	@Convert(converter=TimeConverter.class)
	private Long lastDmlTime;

	public Location() {}

	public Location(String name) {
		this.name = name;
		lastDmlTime = new Date().getTime();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Integer locationTypeId) {
		this.locationTypeId = locationTypeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Long getLastDmlTime() {
		return lastDmlTime;
	}
	
	public void setLastDmlTime(Long lastDmlTime) {
		this.lastDmlTime = lastDmlTime;
	}
}
