package com.netflix.apidata.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@NotEmpty
	private String name;
	
	@ManyToMany
	Set<Title> titleId;
	
	
	
	public Category() {
		super();
	}

	public Category(@NotEmpty String name) {
		super();
		this.name = name;
	}

//	public Set<Title> getTitleId() {
//		return titleId;
//	}
//
//
//
//	public void setTitleId(Set<Title> titleId) {
//		this.titleId = titleId;
//	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}