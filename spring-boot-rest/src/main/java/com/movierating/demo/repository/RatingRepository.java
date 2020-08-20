package com.movierating.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierating.demo.model.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
		
	RatingEntity findByMovieIdInAndCustIdIn(Long movieId, Long custId);
	
	

}
