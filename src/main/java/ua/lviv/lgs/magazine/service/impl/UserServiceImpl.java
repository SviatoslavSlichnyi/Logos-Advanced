package ua.lviv.lgs.magazine.service.impl;

import ua.lviv.lgs.magazine.domain.User;
import ua.lviv.lgs.magazine.repository.UserRepository;
import ua.lviv.lgs.magazine.repository.impl.UserRepositoryImp;
import ua.lviv.lgs.magazine.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private static final UserService userService = new UserServiceImpl();

    private UserServiceImpl() {
        userRepository = UserRepositoryImp.getInstance();
    }

    public static UserService getInstance() {
        return userService;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User deleteById(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
