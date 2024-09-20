package com.example.repository;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.example.model.Movie;

public class MovieRepository {
    Map<Integer, Movie> movies = new HashMap<>();

    public void save(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public Movie get(int id) {
        return movies.get(id);
    }
    
    public List<Integer> getIds(String name) {
        return movies.values().stream().filter(m -> m.getName().equals(name)).mapToInt(m -> m.getId()).boxed().toList();
    }
}
