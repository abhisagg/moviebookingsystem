package com.example.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import com.example.model.Theatre;

public class TheatreRepository {
    Map<Integer, Theatre> theatres = new HashMap<>();

    public void save(Theatre theatre) {
        theatres.put(theatre.getId(), theatre);
    }

    public Theatre get(int id) {
        return theatres.get(id);
    }

    public List<Integer> getIds(String name) {
        return theatres.values().stream().filter(m -> m.getName().equals(name)).mapToInt(m -> m.getId()).boxed().toList();
    }
}
