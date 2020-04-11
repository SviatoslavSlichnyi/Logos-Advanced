package com.lgs.security.service;

import com.lgs.security.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    User save(User user) throws UsernameNotFoundException;

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

    void delete(Long userId);

    boolean existsByUsername(String username);

}
