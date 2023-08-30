package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Language;
import com.project.repo.LanguageRepo;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepo languageRepo;
	
	public List<Language> getAllLanguages() {		
		return (List<Language>) languageRepo.findAll();
	}
	
	public Language addLanguage(Language language) {
		return languageRepo.save(language);
	}

}