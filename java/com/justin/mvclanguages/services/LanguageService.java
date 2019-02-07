package com.justin.mvclanguages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.mvclanguages.models.Language;
import com.justin.mvclanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo=langRepo;
	}
	//	FIND ALL LANGUAGES
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	//	CREATE LANGUAGE
	public Language createLanguage(Language l) {
		return langRepo.save(l);
	}
	//	RETRIEVES A LANGUAGE
	public Language findLanguage(Long id) {
		Optional<Language> lang = langRepo.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		}else {
			return null;
		}
	}
	//	DELETE LANGUAGE
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
	//	UPDATE LANGUAGE
	public Language updateLanguage(Language lang) {
		return langRepo.save(lang);
	}

}
