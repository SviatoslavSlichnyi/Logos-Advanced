package com.lgs.security.service.impl;

import com.lgs.security.entity.Role;
import com.lgs.security.entity.User;
import com.lgs.security.exceptions.EntityNotFoundException;
import com.lgs.security.repository.UserRepository;
import com.lgs.security.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User save(User user) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            throw new UsernameNotFoundException("Username: " +user.getUsername()+ " already exists.");
        }

        user.addRole(new Role(2L, "ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id \"" +id+"\" was NOT found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username: " +username+ " was NOt found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
