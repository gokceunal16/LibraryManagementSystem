package com.example.library.api;

import com.example.library.entity.Publisher;
import com.example.library.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @PostMapping(value = "/publisher")
    @ResponseBody
    public void createPublisher(@RequestBody Publisher publisher){

        publisherService.createPublisher(publisher);
    }

    @GetMapping(value = "/publishers")
    @ResponseBody
    public List<Publisher> getPublishers(){

        return publisherService.getPublishers();
    }

    @GetMapping(value = "/publisher/{id}")
    @ResponseBody
    public Publisher findById(@PathVariable("id") int id){

        return publisherService.findById(id);
    }

    @PutMapping(value = "/publisher/{id}")
    @ResponseBody
    public void updatePublisher(@PathVariable("id") int id, @RequestBody Publisher updatedPublisher){

        publisherService.updatePublisher(id, updatedPublisher);
    }
}
