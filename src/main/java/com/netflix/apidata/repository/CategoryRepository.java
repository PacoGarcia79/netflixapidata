package com.netflix.apidata.repository;

import com.netflix.apidata.entity.Actor;
import com.netflix.apidata.entity.Category;
import com.netflix.apidata.entity.Director;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    List<Director> findByName(@Param("name") String name);
}
