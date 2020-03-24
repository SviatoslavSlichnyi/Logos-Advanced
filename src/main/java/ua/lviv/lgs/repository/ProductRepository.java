package ua.lviv.lgs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
