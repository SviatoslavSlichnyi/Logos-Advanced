package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.repository.BucketRepository;
import ua.lviv.lgs.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.service.BucketService;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository;

    private static BucketService instance;

    public static BucketService getInstance() {
        if (instance == null) {
            instance = new BucketServiceImpl();
        }
        return instance;
    }

    private BucketServiceImpl() {
        this.bucketRepository = BucketRepositoryImpl.getInstance();
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public Bucket findById(Integer id) {
        return bucketRepository.findById(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketRepository.update(bucket);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        bucketRepository.delete(id);
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }

    @Override
    public List<Product> findProductsByUserId(Integer userId) {
        return bucketRepository.findProductsByUserId(userId);
    }

    @Override
    public void deleteByUserIdAndProductId(Integer userId, Integer productId) {
        bucketRepository.deleteByUserIdAndProductId(userId, productId);
    }
}
