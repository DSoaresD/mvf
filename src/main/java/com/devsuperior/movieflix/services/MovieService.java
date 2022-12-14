package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.projections.MovieMinProjections;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(Pageable pageable) {
		Page<Movie> list = repository.findAll(pageable);
		return list.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true)
	public Page<MovieMinDTO> search(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId); 
		Page<MovieMinProjections> list = repository.search(genre,pageable);
		return list.map(x -> new MovieMinDTO(x));
	}

	public List<ReviewDTO> findMovieWithReviews(Long id) {
		Movie movie = repository.getOne(id);
		//Movie entity = repository.findMovieWithReviews(movie);
		List<Review> reviews = reviewRepository.findReviewsByMovieId(movie);
		return reviews.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
		
		
	}

	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(entity);
	}

}
