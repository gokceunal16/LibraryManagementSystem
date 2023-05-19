package com.example.library.api;

import com.example.library.entity.ElectronicPublication;
import com.example.library.service.ElectronicPublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElectronicPublicationController {
    private final ElectronicPublicationService electronic_publicationService;

    public ElectronicPublicationController(ElectronicPublicationService electronic_publicationService) {
        this.electronic_publicationService = electronic_publicationService;
    }


    @PostMapping(value = "/electronic_publication")
    @ResponseBody
    public void createElectronicPublication(@RequestBody ElectronicPublication electronic_publication){

        electronic_publicationService.createElectronicPublication(electronic_publication);
    }

    @GetMapping(value = "/electronic_publications")
    @ResponseBody
    public List<ElectronicPublication> getElectronicPublications(){

        return electronic_publicationService.getElectronicPublications();
    }

    @GetMapping(value = "/electronic_publication/{id}")
    @ResponseBody
    public ElectronicPublication findById(@PathVariable("id") int id){

        return electronic_publicationService.findById(id);
    }

    @PutMapping(value = "/electronic_publication/{id}")
    @ResponseBody
    public void updateElectronicPublication(@PathVariable("id") int id, @RequestBody ElectronicPublication updatedElectronicPublication){

        electronic_publicationService.updateElectronicPublication(id, updatedElectronicPublication);
    }
}
