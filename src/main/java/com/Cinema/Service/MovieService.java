package com.Cinema.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cinema.Dao.MovieDao;
import com.Cinema.Entity.Movie;
import com.Cinema.Exception.MovieNotFoundException;
import com.Cinema.Exception.NoIdFoundException;
import com.Cinema.Exception.RatingException;
import com.Cinema.Exception.YearException;

@Service
public class MovieService {

	@Autowired
	MovieDao md;

	public String setMovie(Movie movie) throws YearException {
	//	try {
			if (movie.getYear() > 2023) {
			throw new YearException("Invalid Year");
		} else {
			return md.setMovie(movie);
		}
		//}
		//catch(YearException e) {
			//return "Invalid Data";
		//}
	}

	public String setallMovie(List<Movie> movie) throws YearException {
		List<Movie> p = movie.stream().filter(x -> x.getYear() <= 2023).collect(Collectors.toList());
		List<Movie> q = movie.stream().filter(x -> x.getYear() > 2023).collect(Collectors.toList());
		if (p.isEmpty()) {
			throw new YearException("Invalid Year");
		} else {
			return md.setallMovie(p);
		}
	}

	public List<Movie> getallMovie() {

		return md.getallMovie();
	}

	public List<Movie> getmovie(String movie) throws MovieNotFoundException {
		
			List<Movie> a = getallMovie();
			List<Movie> b = a.stream().filter(x -> x.getName().equals(movie)).collect(Collectors.toList());

			if (b.isEmpty()) {
				throw new MovieNotFoundException("Movie Name Not Found");
			} else {
				return b;
			}

		
		}

	public List<Movie> getmovierating(int a, int b) throws RatingException {
		List<Movie> m=getallMovie();
		List<Movie> l=m.stream().filter(x->x.getRating()>=a && x.getRating()<=b).collect(Collectors.toList());
		if (l.isEmpty()) {
			throw new RatingException("Wrong range given");
		}
		return l;
	}

	public Movie getmovieid(int id) throws NoIdFoundException{
		
		return md.getmovieid(id);
	}
	
	
	}

