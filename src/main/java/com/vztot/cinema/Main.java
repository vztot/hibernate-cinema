package com.vztot.cinema;

import com.vztot.cinema.config.AppConfig;
import com.vztot.cinema.exception.AuthenticationException;
import com.vztot.cinema.model.CinemaHall;
import com.vztot.cinema.model.Movie;
import com.vztot.cinema.model.MovieSession;
import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.User;
import com.vztot.cinema.security.AuthenticationService;
import com.vztot.cinema.service.CinemaHallService;
import com.vztot.cinema.service.MovieService;
import com.vztot.cinema.service.MovieSessionService;
import com.vztot.cinema.service.OrderService;
import com.vztot.cinema.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext ctx
            = new AnnotationConfigApplicationContext(AppConfig.class);

    private static MovieService movieService = ctx.getBean(MovieService.class);
    private static CinemaHallService cinemaHallService = ctx.getBean(CinemaHallService.class);
    private static MovieSessionService movieSessionService = ctx.getBean(MovieSessionService.class);
    private static AuthenticationService authenticationService =
            ctx.getBean(AuthenticationService.class);
    private static ShoppingCartService shoppingCartService = ctx.getBean(ShoppingCartService.class);
    private static OrderService orderService = ctx.getBean(OrderService.class);

    public static void main(String[] args) throws AuthenticationException {
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
                LocalDateTime.of(2020, 5, 26, 23, 45));
        sevenSamuraiSession.setMovie(movieSevenSamurai);
        sevenSamuraiSession.setCinemaHall(smallHall);
        sevenSamuraiSession = movieSessionService.add(sevenSamuraiSession);

        MovieSession rashmonSession = new MovieSession();
        rashmonSession.setSessionTime(
                LocalDateTime.of(2020, 5, 26, 20, 45));
        rashmonSession.setMovie(movieRashomon);
        rashmonSession.setCinemaHall(bigHall);
        rashmonSession = movieSessionService.add(rashmonSession);

        LocalDate today = LocalDate.of(2020, 5, 22);

        movieSessionService.findAvailableSessions(movieSevenSamurai.getId(), today)
                .forEach(System.out::println);
        movieSessionService.findAvailableSessions(movieRashomon.getId(), today)
                .forEach(System.out::println);

        authenticationService.register("bill@microsoft.com", "apple_sucks");

        User loggedUser = authenticationService.login("bill@microsoft.com", "apple_sucks");
        System.out.println(loggedUser);
        shoppingCartService.addSession(sevenSamuraiSession, loggedUser);
        shoppingCartService.addSession(rashmonSession, loggedUser);

        ShoppingCart shoppingCart = shoppingCartService.getByUser(loggedUser);
        orderService.completeOrder(shoppingCart.getTickets(), shoppingCart.getUser());
        orderService.getOrderHistory(loggedUser).forEach(System.out::println);
    }
}
