package onetomany.dao;

import onetomany.domain.Bucket;
import onetomany.domain.Product;

import java.util.List;

public interface BucketDao extends Dao<Bucket> {
    List<Product> findProductsByUserId(int userId);
    void deleteByUserIdAndProductId(int userId, int productId);
}
