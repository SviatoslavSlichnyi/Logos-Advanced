package ua.lviv.magazine.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;

import java.util.List;

@Repository
public interface BucketRepository extends PagingAndSortingRepository<Bucket, Integer> {

    boolean existsByProductId(int productId);

    boolean existsByUserIdAndProductId(int userId, int productId);

    @Query("select b.product from Bucket b where b.user.id = ?1")
    List<Product> findProductsByUserId(int userId);

    void deleteByUserIdAndProductId(int userId, int productId);

}
