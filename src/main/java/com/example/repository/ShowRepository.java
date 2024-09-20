package com.example.repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.model.SeatType;
import com.example.model.Show;
import com.example.model.SortCriteria;

import java.util.function.Predicate; 
import java.util.stream.*;

@Component
public class ShowRepository {
    Map<Integer, Show> shows = new HashMap<>();

    public void save(Show show) {
        shows.put(show.getId(), show);
    }

    public Show get(int id) {
        return shows.get(id);
    }

    public List<Show> getAvailableShows(LocalDateTime startTime, LocalDateTime endTime, List<Predicate<Show>> predicates, SortCriteria sortCriteria) {
        Stream<Show> availableShows = shows.values()
                                        .stream()
                                        .filter(s -> s.getStartTime().isAfter(startTime) && 
                                                   s.getEndTime().isBefore(endTime) && 
                                                   s.getSeatsLeft() >= 0
                                             );
        for (Predicate<Show> predicate: predicates) {
            availableShows = availableShows.filter(predicate);
        }

        if (sortCriteria == SortCriteria.PRICE) {
            availableShows = availableShows.sorted((s1, s2) -> {
                 return s1.getPriceMap().get(SeatType.Normal) - s2.getPriceMap().get(SeatType.Normal);
            });
        }
        return availableShows.toList();
    }

    public void decrementSeatCount(int id) {
        Show show = shows.get(id);
        show.setSeatsLeft(show.getSeatsLeft() - 1);
        shows.put(id, show);
    }
}
