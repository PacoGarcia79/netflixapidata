package com.netflix.apidata.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netflix.apidata.entity.Title;

@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends PagingAndSortingRepository<Title, Long>{

	List<Title> findByName(@Param("name") String name);
}
