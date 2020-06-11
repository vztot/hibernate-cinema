package com.vztot.cinema.dao;

import com.vztot.cinema.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie getById(Long movieId);
}
