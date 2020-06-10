package com.vztot.cinema.dao.impl;

import com.vztot.cinema.dao.OrderDao;
import com.vztot.cinema.exception.DataProcessingException;
import com.vztot.cinema.model.Order;
import com.vztot.cinema.model.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Order entity: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery(
                    "SELECT DISTINCT ord FROM Order ord "
                            + "LEFT JOIN FETCH ord.tickets "
                            + "WHERE ord.user = :user", Order.class);
            query.setParameter("user", user);
            return query.list();
        } catch (HibernateException e) {
            throw new DataProcessingException("Error retrieving orders by user " + user, e);
        }
    }
}
