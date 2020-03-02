package ua.lviv.lgs.magazine.repository;

import ua.lviv.lgs.magazine.domain.User;

import java.util.Optional;

public interface UserRepository extends CRUDRepository<User> {

    Optional<User> findByEmail(String email);

}
