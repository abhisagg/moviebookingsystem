package com.example.repository;

import java.util.*;

import com.example.model.Screen;

public class ScreenRepository {
    Map<Integer, Screen> screens = new HashMap<>();

    public void save(Screen screen) {
        screens.put(screen.getId(), screen);
    }

    public Screen get(int id) {
        return screens.get(id);
    }   
}
