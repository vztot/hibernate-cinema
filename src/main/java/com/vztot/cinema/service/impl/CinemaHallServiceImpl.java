package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.CinemaHallDao;
import com.vztot.cinema.model.CinemaHall;
import com.vztot.cinema.service.CinemaHallService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private CinemaHallDao cinemaHallDao;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall getById(Long cinemaHallId) {
        return cinemaHallDao.getById(cinemaHallId);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
