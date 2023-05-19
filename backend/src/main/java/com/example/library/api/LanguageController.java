package com.example.library.api;

import com.example.library.entity.Language;
import com.example.library.service.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(value = "/language")
    @ResponseBody
    public void createLanguage(@RequestBody Language language){

        languageService.createLanguage(language);
    }

    @GetMapping(value = "/languages")
    @ResponseBody
    public List<Language> getLanguages(){

        return languageService.getLanguages();
    }

    @GetMapping(value = "/language/{id}")
    @ResponseBody
    public Language findById(@PathVariable("id") int id){

        return languageService.findById(id);
    }


    @PutMapping(value = "/language/{id}")
    @ResponseBody
    public void updateLanguage(@PathVariable("id") int id, @RequestBody Language updatedLanguage){

        languageService.updateLanguage(id, updatedLanguage);
    }
}
