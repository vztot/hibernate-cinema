package com.vztot.cinema.model.dto.request;

import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long movieSessionId;
    private Long movieId;
    private Long cinemaHallId;
    private String sessionTimeString;
}
