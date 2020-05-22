package com.vztot.cinema;

import com.vztot.cinema.lib.Injector;
import com.vztot.cinema.model.CinemaHall;
import com.vztot.cinema.model.Movie;
import com.vztot.cinema.model.MovieSession;
import com.vztot.cinema.service.CinemaHallService;
import com.vztot.cinema.service.MovieService;
import com.vztot.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.vztot.cinema");
    private static MovieService movieService
            = (MovieService) INJECTOR.getInstance(MovieService.class);
    private static MovieSessionService movieSessionService
            = (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
    private static CinemaHallService cinemaHallService
            = (CinemaHallService) INJECTOR.getInstance(CinemaHallService.class);

    public static void main(String[] args) {
        Movie movieSevenSamurai = new Movie();
        movieSevenSamurai.setTitle("Seven Samurai");
        movieSevenSamurai.setDescription(
                "Seven Samurai (Japanese: 七人の侍, Hepburn: Shichinin no Samurai) "
                        + "is a 1954 Japanese epic samurai drama film co-written,"
                        + " edited, and directed by Akira Kurosawa.");
        movieService.add(movieSevenSamurai);

        Movie movieRashomon = new Movie();
        movieRashomon.setTitle("Rashomon");
        movieRashomon.setDescription(
                "Rashomon (羅生門, Rashomon) is a 1950 Jidaigeki psychological "
                        + "thriller/crime film directed by Akira Kurosawa, working"
                        + " in close collaboration with cinematographer Kazuo Miyagawa.");
        movieService.add(movieRashomon);

        movieService.getAll().forEach(System.out::println);

        CinemaHall smallHall = new CinemaHall();
        smallHall.setCapacity(50);
        smallHall.setDescription("Small cinema hall");
        cinemaHallService.add(smallHall);

        CinemaHall bigHall = new CinemaHall();
        bigHall.setCapacity(150);
        bigHall.setDescription("Big cinema hall");
        cinemaHallService.add(bigHall);

        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession sevenSamuraiSession = new MovieSession();
        sevenSamuraiSession.setSessionTime(
                LocalDateTime.of(2020, 05, 22, 22,45));
        sevenSamuraiSession.setMovie(movieSevenSamurai);
        sevenSamuraiSession.setCinemaHall(smallHall);
        movieSessionService.add(sevenSamuraiSession);

        MovieSession rashmonSession = new MovieSession();
        rashmonSession.setSessionTime(
                LocalDateTime.of(2020, 05, 22, 20, 45));
        rashmonSession.setMovie(movieRashomon);
        rashmonSession.setCinemaHall(bigHall);
        movieSessionService.add(rashmonSession);

        LocalDate today = LocalDate.of(2020, 5, 22);

        System.out.println("SESSIONS:");
        movieSessionService.findAvailableSessions(movieSevenSamurai.getId(), today)
                .forEach(System.out::println);
        movieSessionService.findAvailableSessions(movieRashomon.getId(), today)
                .forEach(System.out::println);
    }
}
