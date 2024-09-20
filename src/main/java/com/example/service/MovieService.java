package com.example.service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie create(String name) {
        Movie movie = new Movie(name);
        movieRepository.save(movie);
        return movie;
    }

    public Movie get(int id) {
        return movieRepository.get(id);
    } 

    public List<Integer> getIds(String movieName) {
        return movieRepository.getIds(movieName);
    }
}
