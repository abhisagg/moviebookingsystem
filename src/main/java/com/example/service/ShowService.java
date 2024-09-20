package com.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.SeatType;
import com.example.model.Show;
import com.example.model.ShowFilter;
import com.example.model.SortCriteria;
import com.example.repository.ShowRepository;
import java.util.function.Predicate; 

public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatService seatService;

    @Autowired 
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    public Show create(int theatreId, int movieId, int screenId, LocalDateTime startTime, 
                       LocalDateTime endTime, Map<SeatType,Integer> priceMap) {
        Show show = new Show(theatreId, movieId, screenId, startTime, endTime, priceMap);
        show.setSeatsLeft(seatService.getSeatsCount(screenId));
        showRepository.save(show);
        return show;
    }

    public Show get(int id) {
        return showRepository.get(id);
    }

    private void addMovieNamePredicate(List<Predicate<Show>> predicates, String movieName) {
        if (movieName != null) {
            List<Integer> movieIds = movieService.getIds(movieName);
            predicates.add((s) -> {
                return movieIds.contains(s.getMovieId());
            });
        }
    }

    private void addTheatreNamePredicate(List<Predicate<Show>> predicates, String theatreName) {
        if (theatreName != null) {
            List<Integer> theatreIds = theatreService.getIds(theatreName);
            predicates.add((s) -> {
                return theatreIds.contains(s.getTheatreId());
            });
        }
    }

    public List<Show> getAvailableShows(LocalDateTime startTime, LocalDateTime endTime, ShowFilter filter, SortCriteria sortCriteria) {
        List<Predicate<Show>> predicates = new ArrayList<>();
        addMovieNamePredicate(predicates, filter.getMovieName());
        addTheatreNamePredicate(predicates, filter.getTheatreName());
        return showRepository.getAvailableShows(startTime, endTime, predicates, sortCriteria);
    }

    public void decrementSeatCount(int id) {
        showRepository.decrementSeatCount(id);
    }
}
