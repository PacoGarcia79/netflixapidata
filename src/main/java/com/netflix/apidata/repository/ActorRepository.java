package com.netflix.apidata.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netflix.apidata.entity.Actor;

@RepositoryRestResource(collectionResourceRel = "actor", path = "actor")
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long>{

	List<Actor> findByNameContaining(@Param("name") String name);
}
