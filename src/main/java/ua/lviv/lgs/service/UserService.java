package ua.lviv.lgs.service;


import ua.lviv.lgs.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User> {

    Optional<User> findByEmail(String email);

}
