package ua.lviv.lgs.magazine.service;

import ua.lviv.lgs.magazine.domain.User;

import java.util.Optional;

public interface UserService extends CRUDService<User> {

    Optional<User> findByEmail(String email);

}
