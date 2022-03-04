package com.yildizan.newsfrom.api.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yildizan.newsfrom.api.utility.TimeConverter;

@Entity
public class Phrase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer locationId;
	
	@Column(name = "content", updatable = false)
	private String content;
	
	private Integer totalCount;

	@Column(name = "last_dml_time", insertable = false)
	@Convert(converter=TimeConverter.class)
	private Long lastDmlTime;
	
	public Phrase() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Long getLastDmlTime() {
		return lastDmlTime;
	}

	public void setLastDmlTime(Long lastDmlTime) {
		this.lastDmlTime = lastDmlTime;
	}

	@Override
	public int hashCode() {
		return id ^ locationId;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		else if(o instanceof String) {
			return content.equals((String) o);
		}
		else if(o instanceof Phrase) {
			return content.equals(((Phrase) o).getContent());
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return content;
	}
}
