package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Genre;
import com.project.repo.GenreRepo;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepo genreRepo;
	
	public List<Genre> getAllGenres() {		
		return (List<Genre>) genreRepo.findAll();
	}
	
	public Genre addGenre(Genre genre) {
		return genreRepo.save(genre);
	}

}