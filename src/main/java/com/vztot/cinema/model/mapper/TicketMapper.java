package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.Ticket;
import com.vztot.cinema.model.dto.response.TicketResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    private final MovieSessionMapper movieSessionMapper;
    private final UserMapper userMapper;

    public TicketMapper(MovieSessionMapper movieSessionMapper, UserMapper userMapper) {
        this.movieSessionMapper = movieSessionMapper;
        this.userMapper = userMapper;
    }

    public TicketResponseDto buildTicketResponseDtoFromTicket(Ticket ticket) {
        TicketResponseDto dto = new TicketResponseDto();
        dto.setId(ticket.getId());
        dto.setMovieSession(movieSessionMapper
                .buildMovieSessionResponseDtoFromMovieSession(ticket.getMovieSession()));
        dto.setUser(userMapper.buildUserResponseDtoFromUser(ticket.getUser()));
        return dto;
    }
}
