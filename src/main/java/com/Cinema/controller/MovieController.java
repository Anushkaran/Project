package com.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cinema.Entity.Movie;
import com.Cinema.Exception.MovieNotFoundException;
import com.Cinema.Exception.NoIdFoundException;
import com.Cinema.Exception.RatingException;
import com.Cinema.Exception.YearException;
import com.Cinema.Service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService ms;
	

	@PostMapping("/setmovie")
	public String setMovie(@RequestBody Movie movie) throws YearException {
		return ms.setMovie(movie);javjava
	}
	
	@PostMapping("/setallmovie")
	public String setallMovie(@RequestBody List<Movie> movie) throws YearException {
		return ms.setallMovie(movie);
	}
	
	@GetMapping("/getallmovie")
	public List<Movie> getallMovie() {
		return ms.getallMovie();
	}
	
	@GetMapping("/getmoviebyname/{movie}")
	public List<Movie> getmovie(@PathVariable String movie) throws MovieNotFoundException{
		return ms.getmovie(movie);
	}
	
	@GetMapping("/getmoviebyrating/{a}/{b}")
	public List<Movie> getmovierating(@PathVariable int a,@PathVariable int b) throws RatingException {
		return ms.getmovierating(a,b);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public Movie getmovieid(@PathVariable int id) throws NoIdFoundException{
		return ms.getmovieid(id);
		
	}
}

