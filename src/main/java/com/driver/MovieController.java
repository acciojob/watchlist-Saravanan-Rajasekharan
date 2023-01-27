package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;   //DI

    //Post - Create

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Director added", HttpStatus.CREATED);
    }


    // GET

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
       Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);

    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.ACCEPTED);

    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> nameList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(nameList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.ACCEPTED);
    }



    //Delete - Delete
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director +"Removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping()
    public  ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors and movies deleted", HttpStatus.CREATED);
    }


}
