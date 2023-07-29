package com.Cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cinema.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
