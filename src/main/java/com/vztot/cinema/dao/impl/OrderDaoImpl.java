package com.vztot.cinema.dao.impl;

import com.vztot.cinema.dao.OrderDao;
import com.vztot.cinema.exception.DataProcessingException;
import com.vztot.cinema.lib.Dao;
import com.vztot.cinema.model.Order;
import com.vztot.cinema.model.User;
import com.vztot.cinema.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
