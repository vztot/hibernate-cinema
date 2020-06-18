package com.vztot.cinema.dao.impl;

import com.vztot.cinema.dao.RoleDao;
import com.vztot.cinema.exception.DataProcessingException;
import com.vztot.cinema.model.Role;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert entity: " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getById(Long roleId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Role.class, roleId);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get role by id : " + roleId, e);
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Role.RoleName roleNameObject = Role.RoleName.valueOf(roleName);
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Role> query
                    = criteriaBuilder.createQuery(Role.class);
            Root<Role> root = query.from(Role.class);
            Role role = session.createQuery(
                    query.where(criteriaBuilder.equal(root.get("name"), roleNameObject)))
                    .getSingleResult();
            return role;
        } catch (Exception e) {
            throw new DataProcessingException(
                    "There was an error retrieving a role with name " + roleName, e);
        }
    }
}
