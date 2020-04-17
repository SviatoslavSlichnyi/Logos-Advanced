package ua.lviv.magazine.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.repository.BucketRepository;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BucketServiceImpl implements BucketService {

    private final UserService userService;
    private final ProductService productService;
    private final BucketRepository bucketRepository;

    @Override
    public boolean existsByProductId(long id) {
        return bucketRepository.existsByProductId(id);
    }

    @Override
    public boolean existsByUserIdAndProductId(long userId, long productId) {
        return bucketRepository.existsByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<Product> findProductsByUserId(long id) {
        return bucketRepository.findProductsByUserId(id);
    }

    @Override
    @Transactional
    public void deleteByUserIdAndProductId(long userId, long productId) {
        bucketRepository.deleteByUserIdAndProductId(userId, productId);
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public Bucket findById(long id) {
        return bucketRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Bucket with id \"" +id+"\" was NOT found"));
    }

    @Override
    public Bucket update(Bucket bucket) {
        userService.save(bucket.getUser());
        productService.save(bucket.getProduct());
        return bucketRepository.save(bucket);
    }

    @Override
    public void deleteById(long id) {
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
