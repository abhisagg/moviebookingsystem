package com.example.service;

import com.example.model.Theatre;
import com.example.repository.TheatreRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre create(String name) {
        Theatre theatre = new Theatre(name);
        theatreRepository.save(theatre);
        return theatre;
    }

    public Theatre get(int id) {
        return theatreRepository.get(id);
    }

    public List<Integer> getIds(String theatreName) {
        return theatreRepository.getIds(theatreName);
    }
}
