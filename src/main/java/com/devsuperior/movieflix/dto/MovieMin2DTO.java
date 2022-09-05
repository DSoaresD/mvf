package com.devsuperior.movieflix.dto;

import java.util.HashSet;
import java.util.Set;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.MovieMinProjections2;

public class MovieMin2DTO {
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	private Set<ReviewDTO> reviews = new HashSet<>();
	
	public MovieMin2DTO() {
		
	}

	public MovieMin2DTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieMin2DTO(Movie entity, Set<Review> reviews) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
		
		reviews.forEach(r -> this.reviews.add(new ReviewDTO(r)));
	}
	
	public MovieMin2DTO(MovieMinProjections2 projections) {
		id = projections.getId();
		title = projections.getTitle();
		subTitle = projections.getSubTitle();
		year = projections.getYear();
		imgUrl = projections.getImgUrl();
		synopsis = projections.getSynopsis();
		
	}
	
	public MovieMin2DTO(MovieMinProjections2 projections, Set<Review> reviews) {
		id = projections.getId();
		title = projections.getTitle();
		subTitle = projections.getSubTitle();
		year = projections.getYear();
		imgUrl = projections.getImgUrl();
		synopsis = projections.getSynopsis();
		
		reviews.forEach(r -> this.reviews.add(new ReviewDTO(r)));
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Set<ReviewDTO> getReviews() {
		return reviews;
	}
	

}
