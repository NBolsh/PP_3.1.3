package ru.kata.spring.boot_security.demo.service;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User findUserById(Long id);

    PasswordEncoder passwordEncoder();

    Optional<User> findUserByEmail(String email);
    UserDetails loadUserByUsername(String username);
}
