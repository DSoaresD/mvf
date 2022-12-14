package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjections;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(nativeQuery = true, value = "SELECT id, title, sub_title AS subTitle, year, img_url AS imgUrl FROM tb_movie WHERE "
			+ "(:genre IS NULL OR tb_movie.genre_id = :genre)")
	Page<MovieMinProjections> search(Genre genre, Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT * FROM tb_movie WHERE tb_movie.id = :movie")
	Movie findMovieWithReviews(Movie movie);

}

	