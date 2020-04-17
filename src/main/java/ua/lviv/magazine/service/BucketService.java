package ua.lviv.magazine.service;


import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;

import java.util.List;

public interface BucketService extends CrudService<Bucket> {
    boolean existsByProductId(long id);
    boolean existsByUserIdAndProductId(long userId, long productId);
    List<Product> findProductsByUserId(long id);
    void deleteByUserIdAndProductId(long userId, long productId);
}
