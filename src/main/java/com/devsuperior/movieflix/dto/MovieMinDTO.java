package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.projections.MovieMinProjections;

public class MovieMinDTO {
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	
	public MovieMinDTO() {
		
	}

	public MovieMinDTO(Long id, String title, String subTitle, Integer year, String imgUrl) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
	}
	
	public MovieMinDTO(MovieMinProjections projections) {
		id = projections.getId();
		title = projections.getTitle();
		subTitle = projections.getSubTitle();
		year = projections.getYear();
		imgUrl = projections.getImgUrl();
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
	
	

}
