package ua.lviv.lgs.repository;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;

import java.util.List;

public interface BucketRepository extends CrudRepository<Bucket> {
    List<Product> findProductsByUserId(Integer userId);
    void deleteByUserIdAndProductId(Integer userId, Integer productId);
}
