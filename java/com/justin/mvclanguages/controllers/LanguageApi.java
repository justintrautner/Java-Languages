package com.justin.mvclanguages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justin.mvclanguages.models.Language;
import com.justin.mvclanguages.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService langService;
	
	public LanguageApi(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index(){
		return langService.allLanguages();
	}

	@PostMapping("/api/languages")
	public Language create(@RequestParam(value="name")String name, @RequestParam(value="creator")String creator, @RequestParam(value="currentVersion")Integer currentVersion) {
		Language language = new Language(name,creator,currentVersion);
		return langService.createLanguage(language);
	}
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		return language;
	}
	@DeleteMapping("/api/languages/{id}")
	public void destroy(@PathVariable("id")Long id) {
		langService.deleteLanguage(id);
	}
}
