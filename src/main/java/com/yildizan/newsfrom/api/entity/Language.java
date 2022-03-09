package com.yildizan.newsfrom.api.entity;

import com.yildizan.newsfrom.api.utility.TimeConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Language {

	@Id
	private Integer id;
	
	private String name;
	private String code;

	@Column(name = "last_dml_time", insertable = false)
	@Convert(converter= TimeConverter.class)
	private Long lastDmlTime;

}
