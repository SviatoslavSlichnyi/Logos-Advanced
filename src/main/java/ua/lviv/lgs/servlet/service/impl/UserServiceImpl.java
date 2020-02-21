package ua.lviv.lgs.servlet.service.impl;

import ua.lviv.lgs.servlet.entity.User;
import ua.lviv.lgs.servlet.service.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return instance;
    }

    private static UserServiceImpl instance = new UserServiceImpl();

    private int fackeId = 1;
    private Map<Integer, User> fakeDb = new HashMap<>();

    @Override
    public void save(User user) {
        fakeDb.put(fackeId++, user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(fakeDb.values());
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(fakeDb.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return fakeDb.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
}
