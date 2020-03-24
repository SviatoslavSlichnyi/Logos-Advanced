package ua.lviv.lgs.service;


import ua.lviv.lgs.entity.Bucket;
import ua.lviv.lgs.entity.Product;

import java.util.List;

public interface BucketService extends CrudService<Bucket> {
    boolean existsByProductId(int id);
    boolean existsByUserIdAndProductId(int userId, int productId);
    List<Product> findProductsByUserId(int id);
    void deleteByUserIdAndProductId(int userId, int productId);
}
