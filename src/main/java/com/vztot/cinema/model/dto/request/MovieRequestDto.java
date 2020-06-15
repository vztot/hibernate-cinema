package com.vztot.cinema.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieRequestDto {
    @NotNull
    private String title;
    @NotNull
    private String description;
}
