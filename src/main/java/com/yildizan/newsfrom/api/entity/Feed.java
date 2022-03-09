package com.yildizan.newsfrom.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Feed {

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feed")
	private List<News> newsList;

}
