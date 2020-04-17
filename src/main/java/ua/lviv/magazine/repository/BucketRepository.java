package ua.lviv.magazine.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;

import java.util.List;

@Repository
public interface BucketRepository extends PagingAndSortingRepository<Bucket, Long> {

    boolean existsByProductId(long productId);

    boolean existsByUserIdAndProductId(long userId, long productId);

    @Query("select b.product from Bucket b where b.user.id = ?1")
    List<Product> findProductsByUserId(long userId);

    void deleteByUserIdAndProductId(long userId, long productId);

}
