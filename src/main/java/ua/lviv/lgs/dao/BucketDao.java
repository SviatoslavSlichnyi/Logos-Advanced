package ua.lviv.lgs.dao;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;

import java.util.List;

public interface BucketDao extends Dao<Bucket> {
    boolean containsProductById(int id);
    List<Product> findProductsByUserId(int userId);
    void deleteByUserIdAndProductId(int userId, int productId);
}
