package com.yildizan.newsfrom.api.repository;

import com.yildizan.newsfrom.api.entity.News;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {

	@Query("select n, f, l " +
			"from News n, Phrase p, Feed f, Location l " +
			"where n.topPhraseId = p.id " +
			"and n.feedId = f.id " +
			"and p.locationId = l.id")
	List<Object[]> findLocated();
	
	@Query("select n, f, l " +
			"from News n, Phrase p, Feed f, Location l " +
			"where n.topPhraseId = p.id " +
			"and n.feedId = f.id " +
			"and p.locationId = l.id " +
			"and f.categoryId in :categories " +
			"and f.languageId in :languages " +
			"and f.publisherId in :publishers")
	List<Object[]> findLocatedFiltered(int[] categories, int[] languages, int[] publishers);

	@Query("select n, f, l " +
			"from News n, Phrase p, Feed f, Location l " +
			"where n.topPhraseId = p.id " +
			"and n.feedId = f.id " +
			"and p.locationId = l.id " +
			"and n.id = :id")
	Object getById(int id);
}
