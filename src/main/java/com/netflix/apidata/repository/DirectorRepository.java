package com.netflix.apidata.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netflix.apidata.entity.Director;

@RepositoryRestResource(collectionResourceRel = "director", path = "director")
public interface DirectorRepository extends PagingAndSortingRepository<Director, Long> {

	List<Director> findByName(@Param("name") String name);
}
