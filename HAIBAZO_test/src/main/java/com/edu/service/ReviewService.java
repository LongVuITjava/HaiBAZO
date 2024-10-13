package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.Review;

public interface ReviewService {

	void deleteReview(Long reviewId);

	Review saveReview(Review review);

	Optional<Review> getReviewById(Long reviewId);

	List<Review> getAllReviews();


}
