package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.MovieSession;
import com.vztot.cinema.model.dto.request.MovieSessionRequestDto;
import com.vztot.cinema.model.dto.response.MovieSessionResponseDto;
import com.vztot.cinema.service.CinemaHallService;
import com.vztot.cinema.service.MovieService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {

    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieMapper movieMapper;
    private final CinemaHallMapper cinemaHallMapper;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService,
                              MovieMapper movieMapper, CinemaHallMapper cinemaHallMapper) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieMapper = movieMapper;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    public MovieSession buildMovieSessionFromMovieSessionRequestDto(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.getById(dto.getCinemaHallId()));
        movieSession.setSessionTime(LocalDateTime.parse(dto.getSessionTimeString()));
        return movieSession;
    }

    public MovieSessionResponseDto buildMovieSessionResponseDtoFromMovieSession(
            MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setMovie(movieMapper.buildMovieResponseDtoFromMovie(movieSession.getMovie()));
        dto.setCinemaHall(cinemaHallMapper
                .buildCinemaHallResponseDtoFromCinemaHall(movieSession.getCinemaHall()));
        dto.setSessionTime(movieSession.getSessionTime());
        return dto;
    }
}
