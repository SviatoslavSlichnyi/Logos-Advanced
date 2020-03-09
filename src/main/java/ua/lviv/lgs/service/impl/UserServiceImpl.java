package ua.lviv.lgs.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.repository.UserRepository;
import ua.lviv.lgs.repository.impl.UserRepositoryImp;
import ua.lviv.lgs.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    Logger log = Logger.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;
    private static UserServiceImpl userServise;

    private UserServiceImpl() {
        userRepository = UserRepositoryImp.getInstance();
    }

    public static UserServiceImpl getInstance() {
        if (userServise == null) {
            userServise = new UserServiceImpl();
        }
        return userServise;
    }

    @Override
    public User save(User user) {
        log.debug("save user" + user);
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        log.debug("find user by id" + id);
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        log.debug("update user" + user);
        return userRepository.update(user);
    }

    @Override
    public void delete(Integer id) {
        log.debug("delete user by id: " + id);
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        log.debug("find all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.debug("find user by email" + email);
        return userRepository.findByEmail(email);
    }
}
