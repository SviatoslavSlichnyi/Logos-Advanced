package onetomany.dao.impl;

import connection.ConnectionManager;
import onetomany.dao.UserDao;
import onetomany.domain.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDaoImp implements UserDao {

    private Logger log = Logger.getLogger(UserDaoImp.class);
    private static final UserDao instance = new UserDaoImp();

    private final static String FIND_BY_EMAIL = "select u from User u where email = ?1";
    private final static String READ_ALL = "select u from User u";

    private final EntityManager em;

    private UserDaoImp() {
        this.em = ConnectionManager.createEntityManager();
    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public User save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public Optional<User> get(int id) throws IllegalArgumentException {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();

        return Optional.ofNullable(user);
    }

    @Override
    public User update(User user) throws IllegalArgumentException {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public void delete(User user) throws IllegalArgumentException {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery(FIND_BY_EMAIL, User.class);
        User user = null;
        try {
            user = query.setParameter(1, email).getSingleResult();
        } catch (NoResultException e) {
            em.getTransaction().commit();
            return Optional.ofNullable(user);
        }
        em.getTransaction().commit();

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery(READ_ALL, User.class);
        List<User> users = query.getResultList();
        em.getTransaction().commit();

        return users;
    }
}
