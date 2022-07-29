package com.netflix.apidata.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.netflix.apidata.validation.MaxCurrentYear;

@Entity
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	private String date_added;

	@NotBlank(message = "Year is mandatory")
	@Min(1900)
	@MaxCurrentYear
	// private String release_year;
	private String releaseYear;

	@NotNull(message = "Number of reviews is mandatory")
	@Min(0)
	@Max(10)
	private String rating;
	private String duration;
	private String description;
	private double user_rating;

	@ManyToMany
	Set<Actor> actor;

	@ManyToMany
	Set<Director> director;

	@ManyToMany
	Set<Category> category;

	public Title() {
		super();
	}

	public Title(String id, String name, String date_added, String releaseYear, String rating, String duration,
			String description, double user_rating) {
		super();
		this.id = id;
		this.name = name;
		this.date_added = date_added;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.duration = duration;
		this.description = description;
		this.user_rating = user_rating;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(double user_rating) {
		this.user_rating = user_rating;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", name=" + name + ", date_added=" + date_added + ", release_year=" + releaseYear
				+ ", rating=" + rating + ", duration=" + duration + ", description=" + description + ", user_rating="
				+ user_rating + "]";
	}

}