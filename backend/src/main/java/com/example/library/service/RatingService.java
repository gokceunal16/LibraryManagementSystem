package com.example.library.service;

import com.example.library.entity.Rating;
import com.example.library.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void createRating(Rating rating) {
        ratingRepository.createRating(rating);
    }

    public List<Rating> getRatings() {
        return ratingRepository.getRatings();
    }

    public Rating find(int user_id, int publication_id) {
        return ratingRepository.find(user_id, publication_id);
    }

    public void updateRating(int userId, int publicationId, Rating rating) {
        ratingRepository.updateRating(userId, publicationId, rating);
    }

    public void deleteRating(int user_id, int publication_id) {
        ratingRepository.deleteRating(user_id, publication_id);
    }
}
