package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.MovieRequestDto;
import com.vztot.cinema.model.dto.response.MovieResponseDto;
import com.vztot.cinema.model.mapper.MovieMapper;
import com.vztot.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    private MovieMapper mapper;

    public MovieController(MovieService movieService, MovieMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping
    private void addMovie(@RequestBody MovieRequestDto dto) {
        movieService.add(mapper.buildMovieFromMovieRequestDto(dto));
    }

    @GetMapping
    private List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(mapper::buildMovieResponseDtoFromMovie)
                .collect(Collectors.toList());
    }
}
