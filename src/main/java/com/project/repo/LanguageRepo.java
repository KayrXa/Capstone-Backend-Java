package com.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, String>{
	

}