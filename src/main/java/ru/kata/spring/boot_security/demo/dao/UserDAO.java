package ru.kata.spring.boot_security.demo.dao;




import ru.kata.spring.boot_security.demo.model.User;


import java.util.List;
import java.util.Optional;


public interface UserDAO {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User findUserById(Long id);

    Optional<User> findUserByEmail(String email);

//    List<Role> showUserRoles(User user);

}

