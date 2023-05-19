package com.example.library.api;

import com.example.library.entity.PublicationAvailableNotificationRequest;
import com.example.library.entity.Rating;
import com.example.library.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @PostMapping(value = "/rating")
    @ResponseBody
    public void createRating(@RequestBody Rating rating){

        ratingService.createRating(rating);
    }

    @GetMapping(value = "/ratings")
    @ResponseBody
    public List<Rating> getRatings(){

        return ratingService.getRatings();
    }

    @GetMapping(value = "/rating")
    @ResponseBody
    public Rating find(@RequestParam("user_id") int user_id, @RequestParam("publication_id") int publication_id){
        return ratingService.find(user_id, publication_id);
    }

    @PutMapping(value = "/rating")
    @ResponseBody
    public void updateRating(@RequestParam("user_id") int user_id, @RequestParam("publication_id") int publication_id, @RequestBody Rating updatedRating){

        ratingService.updateRating(user_id, publication_id, updatedRating);
    }

    @DeleteMapping(value = "/rating")
    @ResponseBody
    public void deleteRating(@RequestParam("user_id") int user_id, @RequestParam("publication_id") int publication_id){

        ratingService.deleteRating(user_id, publication_id);
    }
}
