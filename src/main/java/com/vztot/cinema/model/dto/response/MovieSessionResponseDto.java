package com.vztot.cinema.model.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private MovieResponseDto movie;
    private CinemaHallResponseDto cinemaHall;
    private LocalDateTime sessionTime;
}
