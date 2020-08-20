package com.movierating.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_RATING")
public class RatingEntity {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long rtId;
	 
	
	@Column(name="movieId")
    private Long movieId;
	
	@Column(name="custId")
    private Long custId;
	
	@Column(name="rating")
    private Long rating;
	
	public RatingEntity (int movieId, int custId, int rating) {
		this.movieId = (long) movieId;
		this.custId = (long) custId;
		this.rating = (long) rating;
	}
	
	public RatingEntity () {
		
	}

	
	  public Long getRtId() { return rtId; }
	  
	  public void setRtId(Long rtId) { this.rtId = rtId; }
	 

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RatingEntity [movieId=" + movieId + ", custId=" + custId + ", rating=" + rating
				+ "]";
	}

	

}
