package com.movierating.demo.model;

public class RatedMovie {
	
	private Long movieId;
	private Double rating;
	
	public RatedMovie(Long movieId, Double rating) {
		this.movieId = movieId;
		this.rating = rating;
	}
	
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RatedMovie [movieId=" + movieId + ", rating=" + rating + "]";
	}

}
