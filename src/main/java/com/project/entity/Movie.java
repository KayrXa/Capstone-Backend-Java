package com.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String moviename;
	private String language;
	private double ticketprice;
	private String description;
	private String imageurl;
	private String genre;
	private LocalDate moviedate;
	private String movietime;
	private boolean movieenabled;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String moviename, String language, double ticketprice, String description, String imageurl,
			String genre, LocalDate moviedate, String movietime, boolean movieenabled) {
		super();
		this.moviename = moviename;
		this.language = language;
		this.ticketprice = ticketprice;
		this.description = description;
		this.imageurl = imageurl;
		this.genre = genre;
		this.moviedate = moviedate;
		this.movietime = movietime;
		this.movieenabled = movieenabled;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getMoviedate() {
		return moviedate;
	}

	public void setMoviedate(LocalDate moviedate) {
		this.moviedate = moviedate;
	}

	public String getMovietime() {
		return movietime;
	}

	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}

	public boolean isMovieenabled() {
		return movieenabled;
	}

	public void setMovieenabled(boolean movieenabled) {
		this.movieenabled = movieenabled;
	}

}