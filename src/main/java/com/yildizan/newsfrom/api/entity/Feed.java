package com.yildizan.newsfrom.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

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

	@OneToMany(mappedBy = "feed")
	private List<News> newsList;

	public boolean hasLocatedNews() {
		return newsList.stream().anyMatch(BaseNews::isLocated);
	}

	public void filterNews() {
		newsList.removeIf(BaseNews::isNotLocated);
	}

}
