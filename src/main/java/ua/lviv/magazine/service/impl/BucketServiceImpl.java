package ua.lviv.magazine.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.repository.BucketRepository;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BucketServiceImpl implements BucketService {

    private final UserService userService;
    private final ProductService productService;
    private final BucketRepository bucketRepository;

    public BucketServiceImpl(UserService userService, ProductService productService, BucketRepository bucketRepository) {
        this.userService = userService;
        this.productService = productService;
        this.bucketRepository = bucketRepository;
    }

    @Override
    public boolean existsByProductId(int id) {
        return bucketRepository.existsByProductId(id);
    }

    @Override
    public boolean existsByUserIdAndProductId(int userId, int productId) {
        return bucketRepository.existsByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<Product> findProductsByUserId(int id) {
        return bucketRepository.findProductsByUserId(id);
    }

    @Override
    public void deleteByUserIdAndProductId(int userId, int productId) {
        bucketRepository.deleteByUserIdAndProductId(userId, productId);
    }

    @Override
    public Bucket save(Bucket bucket) {
        userService.save(bucket.getUser());
        productService.save(bucket.getProduct());
        return bucketRepository.save(bucket);
    }

    @Override
    public Optional<Bucket> findById(int id) {
        return bucketRepository.findById(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        userService.save(bucket.getUser());
        productService.save(bucket.getProduct());
        return bucketRepository.save(bucket);
    }

    @Override
    public void deleteById(int id) {
        bucketRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bucketRepository.deleteAll();
    }

    @Override
    public List<Bucket> findAll() {
        Iterable<Bucket> all = bucketRepository.findAll();
        List<Bucket> bucketList = new ArrayList<>();
        all.forEach(bucketList::add);
        return bucketList;
    }
}
