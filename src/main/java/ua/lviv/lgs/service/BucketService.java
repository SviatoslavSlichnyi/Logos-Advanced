package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;

import java.util.List;

public interface BucketService extends CrudService<Bucket> {
    boolean containsProductById(int id);
    List<Product> findProductsByUserId(int id);
    void deleteByUserIdAndProductId(int userId, int productId);
}
