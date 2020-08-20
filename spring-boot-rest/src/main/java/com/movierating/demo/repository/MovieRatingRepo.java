package com.movierating.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movierating.demo.model.RatedCustomer;
import com.movierating.demo.model.RatedMovie;
import com.movierating.demo.model.RatingEntity;

@Repository
public interface MovieRatingRepo extends JpaRepository<RatingEntity, Long>{
	@Query("SELECT " +
	           "    new com.movierating.demo.model.RatedMovie(v.movieId, round(SUM(v.rating)/count(*),2)) " +
	           "FROM " +
	           "    RatingEntity v " +
	           "GROUP BY " +
	           "    v.movieId")
	List<RatedMovie> getRatedMovies();
	@Query("SELECT " +
	           "    new com.movierating.demo.model.RatedCustomer(v.custId, count(v.custId), round(SUM(v.rating)/count(v.custId),2)) " +
	           "FROM " +
	           "    RatingEntity v " +
	           "GROUP BY " +
	           "    v.custId order by count(v.custId) desc")
	List<RatedCustomer> getCutomerRating();

}
