package ua.lviv.lgs.magazine.service.impl;

import ua.lviv.lgs.magazine.domain.Product;
import ua.lviv.lgs.magazine.repository.ProductRepository;
import ua.lviv.lgs.magazine.repository.impl.ProductRepositoryImpl;
import ua.lviv.lgs.magazine.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    public static final ProductServiceImpl product = new ProductServiceImpl();
    public ProductRepository productRepository = ProductRepositoryImpl.getInstance();

    private ProductServiceImpl() {}

    public static ProductServiceImpl getInstance() {
        return product;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product deleteById(Integer id) {
        return productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
