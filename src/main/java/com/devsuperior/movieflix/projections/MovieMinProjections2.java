package com.devsuperior.movieflix.projections;

import java.util.Set;

import com.devsuperior.movieflix.entities.Review;

public interface MovieMinProjections2 {
	
	Long getId();
	String getTitle();
	String getSubTitle();
	Integer getYear();
	String getImgUrl();
	String getSynopsis();
	Set<Review> getReviews();

}
