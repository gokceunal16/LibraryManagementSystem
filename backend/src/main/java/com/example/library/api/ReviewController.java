package com.example.library.api;

import com.example.library.entity.Review;
import com.example.library.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping(value = "/review")
    @ResponseBody
    public void createReview(@RequestBody Review review){

        reviewService.createReview(review);
    }

    @GetMapping(value = "/reviews")
    @ResponseBody
    public List<Review> getReviews(){

        return reviewService.getReviews();
    }

    @GetMapping(value = "/review/{id}")
    @ResponseBody
    public Review findById(@PathVariable("id") int id){

        return reviewService.findById(id);
    }

    @PutMapping(value = "/review/{id}")
    @ResponseBody
    public void updateReview(@PathVariable("id") int id, @RequestBody Review updatedReview){

        reviewService.updateReview(id, updatedReview);
    }
}
