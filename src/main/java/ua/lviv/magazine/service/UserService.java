package ua.lviv.magazine.service;


import ua.lviv.magazine.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Long> findIdByEmail(String email);
}
