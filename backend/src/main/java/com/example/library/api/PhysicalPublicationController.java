package com.example.library.api;

import com.example.library.entity.PhysicalPublication;
import com.example.library.service.PhysicalPublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhysicalPublicationController {
    private final PhysicalPublicationService physical_publicationService;

    public PhysicalPublicationController(PhysicalPublicationService physical_publicationService) {
        this.physical_publicationService = physical_publicationService;
    }


    @PostMapping(value = "/physical_publication")
    @ResponseBody
    public void createPhysicalPublication(@RequestBody PhysicalPublication physical_publication){

        physical_publicationService.createPhysicalPublication(physical_publication);
    }

    @GetMapping(value = "/physical_publications")
    @ResponseBody
    public List<PhysicalPublication> getPhysicalPublications(){

        return physical_publicationService.getPhysicalPublications();
    }

    @GetMapping(value = "/physical_publication/{id}")
    @ResponseBody
    public PhysicalPublication findById(@PathVariable("id") int id){

        return physical_publicationService.findById(id);
    }

    @PutMapping(value = "/physical_publication/{id}")
    @ResponseBody
    public void updatePhysicalPublication(@PathVariable("id") int id, @RequestBody PhysicalPublication updatedPhysicalPublication){

        physical_publicationService.updatePhysicalPublication(id, updatedPhysicalPublication);
    }
}
