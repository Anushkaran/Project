package com.Cinema.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cinema.Entity.Movie;
import com.Cinema.Exception.NoIdFoundException;
import com.Cinema.Repository.MovieRepository;
@Repository
public class MovieDao {
@Autowired
MovieRepository mr;
	public String setMovie(Movie movie) {
		mr.save(movie);
		return "save";
	}
	
	public String setallMovie(List<Movie> movie) {
		mr.saveAll(movie);
		return "Success";
	}

	public List<Movie> getallMovie() {
		
		return mr.findAll();
	}

//	public Movie getmovieid(int id) {
//		
//		
//		return mr.findById(id).get();
//	}
	
	public Movie getmovieid(int id) throws NoIdFoundException {
		return mr.findById(id).orElseThrow(()->new NoIdFoundException("Id entered is wrong"));
	}
	

}
