package ua.lviv.lgs;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImp;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.utils.HibernateSessionFactoryUtil;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        User user = User.builder()
                .firstName("Steve")
                .lastName("Jobs")
                .email("sj@gmail.com")
                .password("apple")
                .role("USER")
                .buckets(new HashSet<>())
                .build();

        UserDao userDao = UserDaoImp.getInstance();

        userDao.save(user);
        System.out.println("Done");

        HibernateSessionFactoryUtil.closeSessionFactory();
    }
}
