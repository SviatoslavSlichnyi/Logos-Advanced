package onetomany.dao;

import onetomany.domain.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByEmail(String email);
}
