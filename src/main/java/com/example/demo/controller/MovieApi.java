package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
