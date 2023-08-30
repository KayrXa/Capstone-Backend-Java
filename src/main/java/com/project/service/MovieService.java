package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Movie;
import com.project.repo.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	public List<Movie> getAllMovies() {		
		return (List<Movie>) movieRepo.findAll();
	}
	
	public List<Movie> getAvailableMovies() {		
		return (List<Movie>) movieRepo.findByMovieenabled(true);
	}
	
	public Optional<Movie> getMovieById(String mid) {
		return movieRepo.findById(mid);
	}
	
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public Movie editMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	public void deleteMovie(String mid) {
		movieRepo.deleteById(mid);
	}

}