package com.netflix.apidata.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netflix.apidata.entity.Title;

@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends PagingAndSortingRepository<Title, Long> {

	List<Title> findByNameContaining(@Param("name") String name);

	List<Title> findByDescriptionContaining(@Param("description") String description);

	List<Title> findByReleaseYearContaining(@Param("releaseYear") String releaseYear);

	@Query(value = "SELECT * FROM title t\n" + "inner join title_director td\n" + "on td.title_id = t.id\n"
			+ "inner join director d\n" + "on td.director_id = d.id\n" + "where d.name = ?1", nativeQuery = true)
	List<Title> findTitlesByDirector(@Param("name") String name);

	@Query(value = "SELECT * FROM title t\n" + "inner join title_actor ta\n" + "on ta.title_id = t.id\n"
			+ "inner join actor a\n" + "on ta.actor_id = a.id\n" + "where a.name = ?1", nativeQuery = true)
	List<Title> findTitlesByActor(@Param("name") String name);

	@Query(value = "SELECT * FROM title t\n" + "inner join title_category tc\n" + "on tc.title_id = t.id\n"
			+ "inner join category c\n" + "on tc.category_id = c.id\n" + "where c.name = ?1", nativeQuery = true)
	List<Title> findTitlesByCategory(@Param("name") String name);

	// START RECOMMENDATIONS

	@Query(value = "select * from title order by user_rating DESC", nativeQuery = true)
	List<Title> findTitlesByBestRating(Pageable topLimit);

	@Query(value = "SELECT * FROM title t\n"
			+ "inner join title_category tc\n"
			+ "on tc.title_id = t.id\n"
			+ "inner join category c\n"
			+ "on tc.category_id = c.id\n"
			+ "where c.id = ?1\n"
			+ "order by t.user_rating DESC", nativeQuery = true)
	List<Title> findTitlesByCategoryAndBestRating(Long id, Pageable topLimit); 
	
	// END RECOMMENDATIONS

}
