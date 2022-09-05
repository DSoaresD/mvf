package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjections;
import com.devsuperior.movieflix.projections.MovieMinProjections2;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(nativeQuery = true, value = "SELECT tb_movie.title, tb_movie.sub_title, tb_movie.year, tb_movie.img_url FROM tb_movie WHERE "
			+ "(:genre IS NULL OR tb_movie.genre_id = :genre)")
	Page<MovieMinProjections> search(Genre genre, Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT tb_movie.id, tb_movie.title, tb_movie.sub_title, tb_movie.year, tb_movie.img_url, tb_movie.synopsis FROM tb_movie WHERE tb_movie.id = :movie")
	MovieMinProjections2 findMovieWithReviews(Movie movie);

}

	