package com.justin.mvclanguages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.mvclanguages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

	List<Language> findAll();
}
