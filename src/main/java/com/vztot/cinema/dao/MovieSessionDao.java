package com.vztot.cinema.dao;

import com.vztot.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    List<MovieSession> getAll();

    MovieSession getById(Long movieSessionId);
}
