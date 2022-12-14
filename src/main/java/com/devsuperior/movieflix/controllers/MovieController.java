package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMin2DTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
//	@GetMapping
//	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
//		Page<MovieDTO> list = service.findAllPaged(pageable);		
//		return ResponseEntity.ok().body(list);
//	}
	
	@GetMapping
	public ResponseEntity<Page<MovieMinDTO>> search(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,			
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<MovieMinDTO> list = service.search(genreId, pageRequest);		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<List<ReviewDTO>> findMovieWithReviews(@PathVariable Long id) {		
		List<ReviewDTO> dto = service.findMovieWithReviews(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {		
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}