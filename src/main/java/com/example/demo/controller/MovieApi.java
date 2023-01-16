package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.MovieRepository;
import com.example.demo.database.entity.Movie;

@RestController
@RequestMapping("/api/movie")
public class MovieApi {

    @Autowired 
    private MovieRepository movieRepository;
    
    /**
     * Default greeting as String
     * http://localhost:8080/api/movie/get
     */
    @GetMapping(value = { "/get" }, produces = "application/json")
    public List<Movie> getAll() {

        List<Movie> movies = movieRepository.findAll();

        return movies;

    }
    
    /**
     * Default greeting as String
     * http://localhost:8080/api/movie/find/1
     */
    @GetMapping(value = { "/find/{id}" }, produces = "application/json")
    public Movie getById(@PathVariable("id") String id) {

        Optional<Movie> movie = movieRepository.findById(Long.valueOf(id));

        if(movie.isPresent()){
            return movie.get();
        }

        return null;

    }


    /**
     * Default greeting as String
     * http://localhost:8080/api/movie/find/1
     */
    @PostMapping(value = { "/add" }, produces = "application/json")
    public Movie getById(final @RequestBody(required = true) Movie newMovie) {

        Movie saved = movieRepository.saveAndFlush(newMovie);
        Long newId = saved.getId();
        System.out.println("New ID: " + newId);
        Optional<Movie> movie = movieRepository.findById(newId);

        if(movie.isPresent()){
            return movie.get();
        }

        return null;

    }
}
