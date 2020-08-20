package com.movierating.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TBL_MOVIE")
public class MovieEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	
	@Column(name="movieName")
    private String movieName;

	@Column(name="director")
    private String director;
	
	@Transient
	private double rating;
	
	
	public MovieEntity(String movieName, String director) {
		this.movieName = movieName;
		this.director = director;
	}
	
	public MovieEntity() {
		
	}
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", rating="
				+ rating + "]";
	}

	
	
}
