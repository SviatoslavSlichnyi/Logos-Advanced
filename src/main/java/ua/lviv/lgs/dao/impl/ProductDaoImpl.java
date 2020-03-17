package ua.lviv.lgs.dao.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

	private static final Logger log = Logger.getLogger(ProductServiceImpl.class);
	private static final ProductDao instance = new ProductDaoImpl();

	private static final String READ_ALL = "SELECT p from Product p";

	private final EntityManager em;

	private ProductDaoImpl() {
		this.em = ConnectionManager.createEntityManager();
	}

	public static ProductDao getInstance() {
		return instance;
	}

	@Override
	public Product save(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		return product;
	}

	@Override
	public Optional<Product> get(int id) throws IllegalArgumentException {
		em.getTransaction().begin();
		Product product = em.find(Product.class, id);
		em.getTransaction().commit();

		return Optional.ofNullable(product);
	}

	@Override
	public Product update(Product product) throws IllegalArgumentException {
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();

		return product;
	}

	@Override
	public void delete(Product product) throws IllegalArgumentException {
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}

	@Override
	public List<Product> getAll() {
		em.getTransaction().begin();

		TypedQuery<Product> typedQuery = em.createQuery(READ_ALL, Product.class);
		List<Product> users = typedQuery.getResultList();

		em.getTransaction().commit();
		return users;
	}
}
