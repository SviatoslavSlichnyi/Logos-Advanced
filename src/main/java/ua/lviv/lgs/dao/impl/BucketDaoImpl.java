package ua.lviv.lgs.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.utils.HibernateSessionFactoryUtil;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BucketDaoImpl implements BucketDao {

    private static final Logger log = Logger.getLogger(BucketDaoImpl.class);
    private static final BucketDao instance = new BucketDaoImpl();

    private static final String READ_ALL = "SELECT b from Bucket b";
    private static final String READ_BY_USER_ID = "SELECT b.product FROM Bucket b WHERE b.user.id =?1";
    private static final String READ_BY_PRODUCT_ID = "SELECT count(b.id) FROM Bucket b WHERE b.product.id =?1";
    private static final String READ_BY_USER_ID_AND_PRODUCT_ID = "SELECT b FROM Bucket b WHERE b.user.id =?1 AND b.product.id=?2";

    private BucketDaoImpl() {

    }

    public static BucketDao getInstance() {
        return instance;
    }

    @Override
    public Bucket save(Bucket bucket) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(bucket);

        transaction.commit();
        session.close();

        return bucket;
    }

    @Override
    public Optional<Bucket> get(int id) throws IllegalArgumentException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Bucket bucket = session.get(Bucket.class, id);

        transaction.commit();
        session.close();

        return Optional.ofNullable(bucket);
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Bucket bucket) throws IllegalArgumentException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(bucket);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Bucket> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();

        List<Bucket> buckets = session.createQuery(READ_ALL, Bucket.class).list();

        transaction.commit();
        session.close();

        return buckets;
    }

    @Override
    public boolean containsProductById(int productId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(READ_BY_PRODUCT_ID);
        query.setParameter(1, productId);
        Long count = (Long) query.uniqueResult();


        transaction.commit();
        session.close();

        return count > 0;
    }

    @Override
    public List<Product> findProductsByUserId(int userId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query<Product> query = session.createQuery(READ_BY_USER_ID, Product.class);
        query.setParameter(1, userId);
        List<Product> products = query.list();


        transaction.commit();
        session.close();
        return products;
    }

    @Override
    public void deleteByUserIdAndProductId(int userId, int productId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<Bucket> query = session.createQuery(READ_BY_USER_ID_AND_PRODUCT_ID, Bucket.class);
        query.setParameter(1, userId);
        query.setParameter(2, productId);

        Bucket bucket = query.getSingleResult();
        session.delete(bucket);

        transaction.commit();
        session.close();
    }
}
