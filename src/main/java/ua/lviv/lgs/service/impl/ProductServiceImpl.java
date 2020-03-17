package ua.lviv.lgs.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.service.ProductService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private static final Logger log = Logger.getLogger(ProductServiceImpl.class);
    private static final ProductService instance = new ProductServiceImpl();

    private final ProductDao productDao;

    private ProductServiceImpl() {
        productDao = ProductDaoImpl.getInstance();
    }

    public static ProductService getInstance() {
        return instance;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productDao.get(id);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(int id) {
        Optional<Product> optionalProduct = productDao.get(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productDao.delete(product);
        } else {
            throw new NoResultException();
        }
    }

    @Override
    public List<Product> findAll() {
        return productDao.getAll();
    }
}
