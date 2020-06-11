package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.CinemaHall;
import com.vztot.cinema.model.dto.request.CinemaHallRequestDto;
import com.vztot.cinema.model.dto.response.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHallResponseDto buildCinemaHallResponseDtoFromCinemaHall(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setId(cinemaHall.getId());
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        return dto;
    }

    public CinemaHall buildCinemaHallFromCinemaHallRequestDto(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(dto.getCapacity());
        cinemaHall.setDescription(dto.getDescription());
        return cinemaHall;
    }
}
