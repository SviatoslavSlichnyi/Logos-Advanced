package ua.lviv.lgs.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.entity.Product;
import ua.lviv.lgs.repository.ProductRepository;
import ua.lviv.lgs.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findAll() {
        Iterable<Product> all = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        all.forEach(productList::add);
        return productList;
    }
}
