package com.movierating.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.demo.exception.RecordNotFoundException;
import com.movierating.demo.model.CustomerEntity;
import com.movierating.demo.model.MovieEntity;
import com.movierating.demo.model.RatingEntity;
import com.movierating.demo.service.RatingService;

@RestController
@RequestMapping("/api/rest")
public class RatingController {
	
	@Autowired
	RatingService service;
	
	@PostMapping("/customer/{custId}/movie/{movieId}/rate/{rating}")
    public ResponseEntity<RatingEntity> createRating(@PathVariable Long custId, @PathVariable Long movieId, 
    		@PathVariable Long rating) throws RecordNotFoundException {
		RatingEntity obj = new RatingEntity();
		obj.setCustId(custId);
		obj.setMovieId(movieId);
		obj.setRating(rating);
		RatingEntity response = service.addRating(obj);
        return new ResponseEntity<RatingEntity>(response, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping("/create")
	public void createMovies() {
		service.createData();
	}
	
	@GetMapping("/movie/getMaxRatedMovie")
	public ResponseEntity<MovieEntity> getMaxRated() {
		return new ResponseEntity<MovieEntity>(service.getMaxRated(),new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/movie/getCustomer")
	public ResponseEntity<CustomerEntity> getMaxRatedCustomer() {
		return new ResponseEntity<CustomerEntity>(service.getCustomerRating(),new HttpHeaders(), HttpStatus.OK);
	}

}
