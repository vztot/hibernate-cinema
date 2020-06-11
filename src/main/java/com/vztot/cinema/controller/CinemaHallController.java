package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.CinemaHallRequestDto;
import com.vztot.cinema.model.dto.response.CinemaHallResponseDto;
import com.vztot.cinema.model.mapper.CinemaHallMapper;
import com.vztot.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemahalls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper mapper;

    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    private void addCinemaHall(@RequestBody CinemaHallRequestDto dto) {
        cinemaHallService.add(mapper.buildCinemaHallFromCinemaHallRequestDto(dto));
    }

    @GetMapping
    private List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(mapper::buildCinemaHallResponseDtoFromCinemaHall)
                .collect(Collectors.toList());
    }
}
