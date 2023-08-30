package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Genre;

@Repository
public interface GenreRepo extends CrudRepository<Genre, String>{
	

}