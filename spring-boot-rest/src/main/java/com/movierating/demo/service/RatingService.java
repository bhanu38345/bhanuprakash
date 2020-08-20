package com.movierating.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movierating.demo.exception.RatingException;
import com.movierating.demo.exception.RecordNotFoundException;
import com.movierating.demo.model.CustomerEntity;
import com.movierating.demo.model.MovieEntity;
import com.movierating.demo.model.RatedCustomer;
import com.movierating.demo.model.RatedMovie;
import com.movierating.demo.model.RatingEntity;
import com.movierating.demo.repository.CustomerRepository;
import com.movierating.demo.repository.MovieRatingRepo;
import com.movierating.demo.repository.MovieRepository;
import com.movierating.demo.repository.RatingRepository;


@Service
public class RatingService {
	
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	CustomerRepository custRepository;
	@Autowired
	MovieRatingRepo ratedMovieRepo;
	
	
	public RatingEntity addRating(RatingEntity entity) throws RecordNotFoundException { 
		RatingEntity rec =  ratingRepository.findByMovieIdInAndCustIdIn(entity.getMovieId(), entity.getCustId());
		if(rec != null) {
			rec.setRating(entity.getRating());
			entity = ratingRepository.save(rec);
		}
		else {
		entity = ratingRepository.save(entity);
		}
		
		return entity;
		
	}
	
	public MovieEntity getMaxRated() {
		List<RatedMovie> movieList = ratedMovieRepo.getRatedMovies();
		Optional<MovieEntity> entity = null;
		MovieEntity obj = null;
		if(movieList != null) {
		movieList.sort((RatedMovie a, RatedMovie b)-> b.getRating().compareTo(a.getRating()));
		entity = movieRepository.findById(movieList.get(0).getMovieId());
		}
		if(entity.isPresent()) {
			obj = entity.get();
			obj.setRating(movieList.get(0).getRating());
		}
		return obj;
	}
	
	public CustomerEntity getCustomerRating() {
        List<RatedCustomer> movieList = ratedMovieRepo.getCutomerRating();
		Optional<RatedCustomer> cust = null;
		RatedCustomer obj = null;
		Optional<CustomerEntity> custEntity = null;
		CustomerEntity obj1 = null;
		if(movieList != null && movieList.size() > 0) {
		 cust = movieList.stream().max((RatedCustomer a, RatedCustomer b) -> a.getAvgRating().compareTo(b.getAvgRating()));
		}
		if(cust.isPresent()) {
			obj = cust.get();
			custEntity = custRepository.findById(obj.getCustId());
		}
		if(custEntity.isPresent()) {
			obj1 = custEntity.get();
			obj1.setAvgRating(obj.getAvgRating());
		}
		return obj1;
	}
	
	public void createData() {
		List<MovieEntity> movieList = new ArrayList<MovieEntity>();
		movieList.add(new MovieEntity("Hamilton","Thomas Kail"));
		movieList.add(new MovieEntity("Togo","Ericson Core"));
		movieList.add(new MovieEntity("Klaus","Sergio Pablos"));
		movieList.add(new MovieEntity("Joker","Todd Phillips"));
		movieList.add(new MovieEntity("Green Book","Peter Farrelly"));
		movieList.add(new MovieEntity("Coco","Lee Unkrich"));
		movieList.add(new MovieEntity("Logan","James Mangold"));
		movieList.add(new MovieEntity("Zootopia","Byron Howard"));
		movieList.add(new MovieEntity("Spotlight","Tom McCarthy"));
		
		for(MovieEntity obj : movieList) {
			movieRepository.save(obj);
			
		}
		
		List<CustomerEntity> cusomerList =new ArrayList<CustomerEntity>();
		cusomerList.add(new CustomerEntity("Tom"));
		cusomerList.add(new CustomerEntity("John"));
		cusomerList.add(new CustomerEntity("Igors"));
		cusomerList.add(new CustomerEntity("Mitchell"));
		cusomerList.add(new CustomerEntity("Bryan"));
		cusomerList.add(new CustomerEntity("Lee"));
		cusomerList.add(new CustomerEntity("Sara"));
		cusomerList.add(new CustomerEntity("Sophia"));
		cusomerList.add(new CustomerEntity("Nadia"));
		
		for(CustomerEntity obj : cusomerList) {
			custRepository.save(obj);
		}
		
		List<RatingEntity> ratingList = new ArrayList<RatingEntity>();
		ratingList.add(new RatingEntity(3,2,5));
		ratingList.add(new RatingEntity(1,2,3));
		ratingList.add(new RatingEntity(1,1,3));
		ratingList.add(new RatingEntity(1,5,4));
		ratingList.add(new RatingEntity(2,5,4));
		ratingList.add(new RatingEntity(2,3,4));
		ratingList.add(new RatingEntity(2,6,4));
		ratingList.add(new RatingEntity(3,6,4));
		
		for(RatingEntity obj : ratingList) {
			ratingRepository.save(obj);
		}
	}

}
