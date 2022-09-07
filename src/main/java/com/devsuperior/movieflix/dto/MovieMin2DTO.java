package com.devsuperior.movieflix.dto;

import java.util.HashSet;
import java.util.Set;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.MovieMinProjections2;

public class MovieMin2DTO {
	
	
	private Set<ReviewDTO> reviews = new HashSet<>();
	
	public MovieMin2DTO() {
		
	}
	
	public MovieMin2DTO(Set<Review> reviews) {
		
		reviews.forEach(r -> this.reviews.add(new ReviewDTO(r)));
	}
		
	

	public Set<ReviewDTO> getReviews() {
		return reviews;
	}
	

	
}
