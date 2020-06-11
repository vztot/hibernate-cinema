package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.Movie;
import com.vztot.cinema.model.dto.request.MovieRequestDto;
import com.vztot.cinema.model.dto.response.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie buildMovieFromMovieRequestDto(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }

    public MovieResponseDto buildMovieResponseDtoFromMovie(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }
}
