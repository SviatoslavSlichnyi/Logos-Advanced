package ua.lviv.magazine.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.magazine.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
