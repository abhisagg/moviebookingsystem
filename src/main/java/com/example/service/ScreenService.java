package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Screen;
import com.example.repository.ScreenRepository;
import com.example.repository.TheatreRepository;

public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired 
    private TheatreRepository theatreRepository;

    public Screen create(int theatreId) {
        if (theatreRepository.get(theatreId) == null) {
            System.out.println("Theatre with id doesn't exists");
            return null;
        }
        Screen screen = new Screen(theatreId);
        screenRepository.save(screen);
        return screen;
    }

    public Screen get(int id) {
        return screenRepository.get(id);
    }
}
