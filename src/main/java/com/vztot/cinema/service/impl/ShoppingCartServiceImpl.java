package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.ShoppingCartDao;
import com.vztot.cinema.dao.TicketDao;
import com.vztot.cinema.lib.Inject;
import com.vztot.cinema.lib.Service;
import com.vztot.cinema.model.MovieSession;
import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.Ticket;
import com.vztot.cinema.model.User;
import com.vztot.cinema.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ticket = ticketDao.add(ticket);
        ShoppingCart shoppingCart = getByUser(user);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }
}
