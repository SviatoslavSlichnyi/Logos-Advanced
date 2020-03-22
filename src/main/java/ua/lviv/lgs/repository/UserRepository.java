package ua.lviv.lgs.repository;

import ua.lviv.lgs.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
}
