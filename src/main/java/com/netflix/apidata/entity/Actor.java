package com.netflix.apidata.entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "actor")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;
	
	@ManyToMany
	Set<Title> titleId;

	public Actor() {
		super();
	}

	public Actor(@NotEmpty String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + "]";
	}

}