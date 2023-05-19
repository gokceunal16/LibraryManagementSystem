package com.example.library.api;

import com.example.library.entity.Publication;
import com.example.library.service.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicationController {
    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }


    @PostMapping(value = "/publication")
    @ResponseBody
    public void createPublication(@RequestBody Publication publication){

        publicationService.createPublication(publication);
    }

    @GetMapping(value = "/publications")
    @ResponseBody
    public List<Publication> getPublications(){

        return publicationService.getPublications();
    }

    @GetMapping(value = "/publication/{id}")
    @ResponseBody
    public Publication findById(@PathVariable("id") int id){

        return publicationService.findById(id);
    }

    @PutMapping(value = "/publication/{id}")
    @ResponseBody
    public void updatePublication(@PathVariable("id") int id, @RequestBody Publication updatedPublication){

        publicationService.updatePublication(id, updatedPublication);
    }
}
