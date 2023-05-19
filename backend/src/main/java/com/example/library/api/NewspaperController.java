package com.example.library.api;

import com.example.library.entity.Newspaper;
import com.example.library.service.NewspaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewspaperController {
    private final NewspaperService newspaperService;

    public NewspaperController(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }


    @PostMapping(value = "/newspaper")
    @ResponseBody
    public void createNewspaper(@RequestBody Newspaper newspaper){

        newspaperService.createNewspaper(newspaper);
    }

    @GetMapping(value = "/newspapers")
    @ResponseBody
    public List<Newspaper> getNewspapers(){

        return newspaperService.getNewspapers();
    }

    @GetMapping(value = "/newspaper/{id}")
    @ResponseBody
    public Newspaper findById(@PathVariable("id") int id){

        return newspaperService.findById(id);
    }

    @PutMapping(value = "/newspaper/{id}")
    @ResponseBody
    public void updateNewspaper(@PathVariable("id") int id, @RequestBody Newspaper updatedNewspaper){

        newspaperService.updateNewspaper(id, updatedNewspaper);
    }
}
