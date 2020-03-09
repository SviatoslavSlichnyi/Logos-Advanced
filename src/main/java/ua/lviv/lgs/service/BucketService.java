package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;

import java.util.List;

public interface BucketService extends CrudService<Bucket> {
    List<Product> findProductsByUserId(Integer id);
    void deleteByUserIdAndProductId(Integer userId, Integer productId);
}
