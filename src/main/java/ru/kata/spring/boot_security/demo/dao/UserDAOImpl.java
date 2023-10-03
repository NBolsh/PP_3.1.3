package ru.kata.spring.boot_security.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        String jpql = "SELECT u From User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email){
        String que = "SELECT u From User u left join fetch u.roles where  u.email = :email";

        return Optional.ofNullable(em.createQuery(que, User.class).setParameter("email", email)
                .getSingleResult());
    }

//    @Override
//    public List<Role> showUserRoles(User user){
//
//    }

}
