package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
     return ;
    }
    public void addDirector(Director director) {
        movieRepository.addDirector(director);
        return;
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovie(movieName);
    }
    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirector(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirector(directorName);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }


    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
