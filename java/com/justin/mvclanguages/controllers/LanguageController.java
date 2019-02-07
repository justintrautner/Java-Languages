package com.justin.mvclanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.justin.mvclanguages.models.Language;
import com.justin.mvclanguages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	
	public LanguageController(LanguageService langService) {
		this.langService=langService;
	}
	//	SHOW ALL
	@GetMapping("/languages")
	public String index(Model model, @Valid @ModelAttribute("language") Language language) {
		List<Language> langs = langService.allLanguages();
		model.addAttribute("langs",langs);
		return "/WEB-INF/languages/index.jsp";
	}
	//	DELETE
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable("id")Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	//	SHOW ONE
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("lang", lang);
		return "/WEB-INF/languages/one.jsp";
	}
	//	CREATE
    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/WEB-INF/languages/index.jsp";
        } else {
            langService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    //    EDIT PAGE
    @GetMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model, @Valid @ModelAttribute("language") Language language) {
    	Language lang= langService.findLanguage(id);
    	model.addAttribute("lang", lang);
    	return "/WEB-INF/languages/edit.jsp";
    	
    }
    //    SEND EDIT
    @PutMapping("languages/{id}")
    public String update(@Valid @ModelAttribute("language")Language language, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/WEB-INF/languages/edit.jsp";
    	}else {
    		langService.updateLanguage(language);
    		return "redirect:/languages";
    	}
    }
    
    
    
}
