package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.repository.impl.UserRepositoryImp;
import ua.lviv.lgs.service.UserService;

import java.util.List;

public class UserServiseImpl implements UserService {

    private UserRepository userRepository;

    public UserServiseImpl() {
        userRepository = new UserRepositoryImp();
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
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
