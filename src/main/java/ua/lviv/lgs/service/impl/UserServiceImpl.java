package ua.lviv.lgs.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImp;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);
    private static final UserService instance = new UserServiceImpl();

    private final UserDao userDao;

    private UserServiceImpl() {
        userDao = UserDaoImp.getInstance();
    }

    public static UserService getInstance() {
        return instance;
    }

    @Override
    public User save(User user) {
        log.debug("save user" + user);
        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return userDao.get(id);
    }

    @Override
    public User update(User user) {
        log.debug("update user" + user);
        return userDao.update(user);
    }

    @Override
    public void delete(int id) {
        Optional<User> optionalUser = userDao.get(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userDao.delete(user);
        } else {
            throw new NoResultException();
        }
    }

    @Override
    public List<User> findAll() {
        log.debug("find all users");
        return userDao.getAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        log.debug("find user by email" + email);
        return userDao.findByEmail(email);
    }
}
