package com.example.library.service;

import com.example.library.entity.Language;
import com.example.library.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    public void createLanguage(Language language) {
        languageRepository.createLanguage(language);
    }

    public List<Language> getLanguages() {
        return languageRepository.getLanguages();
    }

    public Language findById(int id) {
        return languageRepository.findById(id);
    }

    public void updateLanguage(int id, Language language) {
        languageRepository.updateLanguage(id, language);
    }
}
