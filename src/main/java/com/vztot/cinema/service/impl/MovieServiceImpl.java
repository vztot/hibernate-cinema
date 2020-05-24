package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.MovieDao;
import com.vztot.cinema.lib.Inject;
import com.vztot.cinema.lib.Service;
import com.vztot.cinema.model.Movie;
import com.vztot.cinema.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
