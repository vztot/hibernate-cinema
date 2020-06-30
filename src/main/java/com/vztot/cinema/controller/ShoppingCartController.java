package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.MovieSessionRequestDto;
import com.vztot.cinema.model.dto.response.ShoppingCartResponseDto;
import com.vztot.cinema.model.mapper.ShoppingCartMapper;
import com.vztot.cinema.service.MovieSessionService;
import com.vztot.cinema.service.ShoppingCartService;
import com.vztot.cinema.service.UserService;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/shopping-carts")
@RestController
public class ShoppingCartController {

    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartMapper mapper;
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(UserService userService, MovieSessionService movieSessionService,
                                  ShoppingCartMapper mapper,
                                  ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add-movie-session")
    private void addMovieSession(Authentication auth,
                                 @RequestBody @Valid MovieSessionRequestDto dto) {
        shoppingCartService.addSession(
                movieSessionService.getById(dto.getMovieSessionId()),
                userService.getByEmail(auth.getName()));
    }

    @GetMapping
    private ShoppingCartResponseDto getByUserId(Authentication auth) {
        return mapper.buildShoppingCartResponseDtoFromShoppingCart(
                shoppingCartService.getByUser(userService.getByEmail(auth.getName())));
    }
}
