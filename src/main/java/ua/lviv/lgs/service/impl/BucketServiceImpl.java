package ua.lviv.lgs.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.service.BucketService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class BucketServiceImpl implements BucketService {

    private static final Logger log = Logger.getLogger(BucketServiceImpl.class);
    private static final BucketService instance = new BucketServiceImpl();

    private final BucketDao bucketDao;

    private BucketServiceImpl() {
        this.bucketDao = BucketDaoImpl.getInstance();
    }

    public static BucketService getInstance() {
        return instance;
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketDao.save(bucket);
    }

    @Override
    public Optional<Bucket> findById(int id) {
        return bucketDao.get(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(int id) {
        Optional<Bucket> optionalBucket = bucketDao.get(id);
        if (optionalBucket.isPresent()) {
            Bucket bucket = optionalBucket.get();
            bucketDao.delete(bucket);
        } else {
            throw new NoResultException();
        }
    }

    @Override
    public List<Bucket> findAll() {
        return bucketDao.getAll();
    }

    @Override
    public boolean containsProductById(int id) {
        return bucketDao.containsProductById(id);
    }

    @Override
    public List<Product> findProductsByUserId(int userId) {
        return bucketDao.findProductsByUserId(userId);
    }

    @Override
    public void deleteByUserIdAndProductId(int userId, int productId) {
        bucketDao.deleteByUserIdAndProductId(userId, productId);
    }
}
