package com.Cinema.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private int year;
	private int rating;
	private String heroName;
	private String directorName;
	private int noOfSongs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public int getNoOfSongs() {
		return noOfSongs;
	}
	public void setNoOfSongs(int noOfSongs) {
		this.noOfSongs = noOfSongs;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + ", heroName=" + heroName
				+ ", directorName=" + directorName + ", noOfSongs=" + noOfSongs + "]";
	}
	
	

}
