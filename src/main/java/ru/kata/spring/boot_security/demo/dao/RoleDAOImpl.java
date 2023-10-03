package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public List<Role> showRoles() {
        String jpql = "SELECT r From Role r";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        return query.getResultList();
    }
}
