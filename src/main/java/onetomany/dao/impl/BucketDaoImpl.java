package onetomany.dao.impl;

import onetomany.dao.BucketDao;
import onetomany.domain.Bucket;
import onetomany.domain.Product;
import org.apache.log4j.Logger;
import connection.ConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BucketDaoImpl implements BucketDao {

    private static final Logger log = Logger.getLogger(BucketDaoImpl.class);
    private static final BucketDao instance = new BucketDaoImpl();

    private static final String READ_ALL = "SELECT b from Bucket b";
    private static final String READ_BY_USER_ID = "SELECT b.product FROM Bucket b WHERE b.user.id =?1";
    private static final String READ_BY_USER_ID_AND_PRODUCT_ID = "SELECT b FROM Bucket b WHERE b.user.id =?1 AND b.product.id=?2";

    private final EntityManager em;

    private BucketDaoImpl() {
        this.em = ConnectionManager.createEntityManager();
    }

    public static BucketDao getInstance() {
        return instance;
    }

    @Override
    public Bucket save(Bucket bucket) {
        em.getTransaction().begin();
        em.persist(bucket);
        em.getTransaction().commit();

        return bucket;
    }

    @Override
    public Optional<Bucket> get(int id) throws IllegalArgumentException {
        em.getTransaction().begin();
        Bucket bucket = em.find(Bucket.class, id);
        em.getTransaction().commit();

        return Optional.ofNullable(bucket);
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Bucket bucket) throws IllegalArgumentException {
        em.getTransaction().begin();
        em.remove(bucket);
        em.getTransaction().commit();
    }

    @Override
    public List<Bucket> getAll() {
        em.getTransaction().begin();

        TypedQuery<Bucket> query = em.createQuery(READ_ALL, Bucket.class);
        List<Bucket> buckets = query.getResultList();

        em.getTransaction().commit();
        return buckets;
    }

    @Override
    public List<Product> findProductsByUserId(int userId) {
        em.getTransaction().begin();

        TypedQuery<Product> query = em.createQuery(READ_BY_USER_ID, Product.class);
        query.setParameter(1, userId);

        List<Product> products = query.getResultList();

        em.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteByUserIdAndProductId(int userId, int productId) {
        em.getTransaction().begin();

        TypedQuery<Bucket> query = em.createQuery(READ_BY_USER_ID_AND_PRODUCT_ID, Bucket.class);
        query.setParameter(1, userId);
        query.setParameter(2, productId);
        Bucket bucket = query.getSingleResult();

        em.remove(bucket);
        em.getTransaction().commit();
    }
}
