package com.movierating.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierating.demo.model.MovieEntity;


@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
