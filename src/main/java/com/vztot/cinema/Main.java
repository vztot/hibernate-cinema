package com.vztot.cinema;

import com.vztot.cinema.lib.Injector;
import com.vztot.cinema.model.Movie;
import com.vztot.cinema.service.MovieService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.vztot.cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);

        Movie movie = new Movie();
        movie.setTitle("Seven Samurai");
        movie.setDescription(
                "Seven Samurai (Japanese: 七人の侍, Hepburn: Shichinin no Samurai) "
                        + "is a 1954 Japanese epic samurai drama film co-written,"
                        + " edited, and directed by Akira Kurosawa.");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
