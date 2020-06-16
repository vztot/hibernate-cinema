package com.vztot.cinema.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CinemaHallRequestDto {
    @Min(1)
    private int capacity;
    @NotNull
    private String description;
}
