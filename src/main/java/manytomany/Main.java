package manytomany;

import connection.ConnectionManager;
import manytomany.dao.UserDao;
import manytomany.dao.impl.UserDaoImp;
import manytomany.domain.Product;
import manytomany.domain.User;

import javax.persistence.EntityManager;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        EntityManager em = ConnectionManager.createEntityManager();

        User user = User.builder()
                .firstName("Steve")
                .lastName("Jobs")
                .email("steve.jobs@gmail.com")
                .password("apple")
                .role("USER")
                .products(new HashSet<>())
                .build();

        Product product = Product.builder()
                .name("iphone")
                .price(1999.90)
                .description("Very expensive phone")
                .users(new HashSet<>())
                .build();

        System.out.println(user.getProducts());
        user.addProduct(product);

        UserDao userDao = UserDaoImp.getInstance();
        userDao.save(user);

        em.close();
        ConnectionManager.closeEntityManagerFactory();
    }
}
