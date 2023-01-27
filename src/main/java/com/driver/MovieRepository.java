package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    Map<String,Movie> dbMovie = new HashMap<>();
    Map<String,Director> dbDirector = new HashMap<>();

    Map<String, List<String>> dbMovieDirector = new HashMap<>();

    // 1.
    public void addMovie(Movie movie){
        String name = movie.getName();
        dbMovie.put(name,movie);
        return ;
    }
    //2.
    public void addDirector(Director director) {
        String name = director.getName();
        dbDirector.put(name,director);
        return ;
    }
    //3.
    public void addMovieDirectorPair(String movie, String director) {
        if(dbMovie.containsKey(movie) && dbDirector.containsKey(director)){
            List<String> movielist = new ArrayList<>();

            if(dbMovieDirector.containsKey(director)){
                movielist = dbMovieDirector.get(director);
                movielist.add(movie);
                dbMovieDirector.put(director,movielist);
            }
        }
    }
    //4.
    public Movie getMovie(String movie){
        return dbMovie.get(movie);
    }
    //5. Find the director object from director name
    public Director getDirector(String director){
        return dbDirector.get(director);
    }
    //6. Get the list of movies of a director
    public List<String> getMoviesByDirector(String directorName) {
        List<String> namelist = null;
        if(dbMovieDirector.containsKey(directorName)){
            namelist = dbMovieDirector.get(directorName);
        }
        return namelist;
    }
    //7. Get all the movies
    public List<String> findAllMovies(){
        return new ArrayList<>(dbMovie.keySet());
    }

    //8. Delete a director and movies -  deleteDirectorByName

    public void deleteDirectorByName(String director){
        List<String> movies = new ArrayList<>();
        if(dbMovieDirector.containsKey(director)){
            movies = dbMovieDirector.get(director);
            for(String movie: movies){
                if(dbMovie.containsKey(movie)){
                    dbMovie.remove(movie);
                }
            }
            // remove director from the director movie pair
            dbMovieDirector.remove(director);
        }
        // removing from the director map

            dbDirector.remove(director);


    }

    //9. Delete all director and all movies - deleteAllDirectors
    public void deleteAllDirectors() {

        HashSet<String> moviesSet = new HashSet<>();

        // Add all movies corresponding to the directors to the hashset

         for(String director : dbMovieDirector.keySet()){
             for(String movie:dbMovieDirector.get(director)){
                 moviesSet.add(movie);
             }
         }
         // remove the movies from the dbmovie using the movie set has set

         for(String movie: moviesSet){
             if(dbMovie.containsKey(movie)){
                 dbMovie.remove(movie);
             }
         }

    }



}
