package ua.lviv.magazine.service;


import ua.lviv.magazine.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User> {

    Optional<User> findByEmail(String email);

}
