package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.MovieSessionRequestDto;
import com.vztot.cinema.model.dto.response.MovieSessionResponseDto;
import com.vztot.cinema.model.mapper.MovieSessionMapper;
import com.vztot.cinema.service.MovieSessionService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviesessions")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper mapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper mapper) {
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
    }

    @PostMapping
    private void addMovieSession(@RequestBody MovieSessionRequestDto dto) {
        movieSessionService.add(mapper.buildMovieSessionFromMovieSessionRequestDto(dto));
    }

    @GetMapping("/available")
    private List<MovieSessionResponseDto> getAllAvailableMovieSessions(@RequestParam Long movieId,
                                                                       @RequestParam String date) {
        return movieSessionService.findAvailableSessions(movieId,
                LocalDateTime.parse(date).toLocalDate()).stream()
                .map(mapper::buildMovieSessionResponseDtoFromMovieSession)
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    private List<MovieSessionResponseDto> getAll() {
        return movieSessionService.getAll()
                .stream().map(mapper::buildMovieSessionResponseDtoFromMovieSession)
                .collect(Collectors.toList());
    }
}
