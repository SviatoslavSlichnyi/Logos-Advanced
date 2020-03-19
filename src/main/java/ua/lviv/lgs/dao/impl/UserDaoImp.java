package ua.lviv.lgs.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.utils.HibernateSessionFactoryUtil;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDaoImp implements UserDao {

    private Logger log = Logger.getLogger(UserDaoImp.class);
    private static final UserDao instance = new UserDaoImp();

    private final static String FIND_BY_EMAIL = "select u from User u where email = ?1";
    private final static String READ_ALL = "select u from User u";

    private UserDaoImp() {

    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public User save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public Optional<User> get(int id) throws IllegalArgumentException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        transaction.commit();
        session.close();

        return Optional.ofNullable(user);
    }

    @Override
    public User update(User user) throws IllegalArgumentException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(user);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public void delete(User user) throws IllegalArgumentException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery(READ_ALL, User.class).list();

        transaction.commit();
        session.close();

        return users;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            TypedQuery<User> query = session.createQuery(FIND_BY_EMAIL, User.class);
            User user = query.setParameter(1, email).getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            transaction.commit();
            session.close();
        }
    }
}
