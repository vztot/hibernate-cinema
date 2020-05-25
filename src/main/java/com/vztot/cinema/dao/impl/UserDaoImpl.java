package com.vztot.cinema.dao.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.exception.DataProcessingException;
import com.vztot.cinema.lib.Dao;
import com.vztot.cinema.model.User;
import com.vztot.cinema.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public User add(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert entity: " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            Predicate predicate = criteriaBuilder.equal(root.get("email"), email);
            return Optional.ofNullable(session.createQuery(query.where(predicate)).uniqueResult());
        } catch (Exception e) {
            throw new DataProcessingException(
                    "Cant find user by email", e);
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
