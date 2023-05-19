package com.example.library.service;

import com.example.library.entity.Review;
import com.example.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void createReview(Review review) {
        reviewRepository.createReview(review);
    }

    public List<Review> getReviews() {
        return reviewRepository.getReviews();
    }

    public Review findById(int id) {
        return reviewRepository.findById(id);
    }

    public void updateReview(int id, Review review) {
        reviewRepository.updateReview(id, review);
    }
}
