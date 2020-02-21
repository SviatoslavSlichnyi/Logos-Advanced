package ua.lviv.lgs.servlet.service;

import ua.lviv.lgs.servlet.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);
}

