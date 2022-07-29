package com.netflix.apidata.entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "actor")
public class Actor{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@NotEmpty
	private String name;



	public Actor() {
		super();
	}



	public Actor(@NotEmpty String name) {
		super();
		this.name = name;
	}









	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}



	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + "]";
	}


}