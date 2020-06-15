package com.vztot.cinema.model.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    @NotNull
    private Long movieSessionId;
    @NotNull
    private Long movieId;
    @NotNull
    private Long cinemaHallId;
    @NotNull
    @Size(min = 10)
    private String sessionTimeString;
}
