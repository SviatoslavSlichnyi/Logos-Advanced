package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.repository.ProductRepository;
import ua.lviv.lgs.repository.impl.ProductRepositoryImpl;
import ua.lviv.lgs.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static ProductService instance;

    private ProductServiceImpl() {
        productRepository = ProductRepositoryImpl.getInstance();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
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
    public void delete(Integer id) throws SQLException {
        try {
            productRepository.delete(id);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
