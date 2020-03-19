package ua.lviv.lgs.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

	private static final Logger log = Logger.getLogger(ProductServiceImpl.class);
	private static final ProductDao instance = new ProductDaoImpl();

	private static final String READ_ALL = "SELECT p from Product p";

	private ProductDaoImpl() {

	}

	public static ProductDao getInstance() {
		return instance;
	}

	@Override
	public Product save(Product product) {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.save(product);

		transaction.commit();
		session.close();

		return product;
	}

	@Override
	public Optional<Product> get(int id) throws IllegalArgumentException {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Product product = session.get(Product.class, id);

		transaction.commit();
		session.close();

		return Optional.ofNullable(product);
	}

	@Override
	public Product update(Product product) throws IllegalArgumentException {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.merge(product);

		transaction.commit();
		session.close();

		return product;
	}

	@Override
	public void delete(Product product) throws IllegalArgumentException {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(product);

		transaction.commit();
		session.close();
	}

	@Override
	public List<Product> getAll() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory()
				.openSession();
		Transaction transaction = session.beginTransaction();

		List<Product> products = session.createQuery(READ_ALL, Product.class).list();

		transaction.commit();
		session.close();

		return products;
	}
}
