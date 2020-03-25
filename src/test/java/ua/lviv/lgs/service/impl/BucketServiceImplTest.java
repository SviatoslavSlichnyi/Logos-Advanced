package ua.lviv.lgs.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ua.lviv.magazine.SpringMagazineApplication;
import ua.lviv.magazine.controller.enumeration.UserRole;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BucketServiceImplTest {

    private static ApplicationContext context;

    private BucketService bucketService;
    private UserService userService;
    private ProductService productService;
    private List<Bucket> bucketsList;
    private int bucketListSize;

    @BeforeAll
    static void init() {
        context = SpringApplication.run(SpringMagazineApplication.class);
    }

    @AfterAll
    static void cleanUp() {
    }

    @BeforeEach
    void setUp() {
        this.bucketService = context.getBean(BucketService.class);
        this.userService = context.getBean(UserService.class);
        this.productService = context.getBean(ProductService.class);
        this.bucketService.deleteAll();
        this.bucketListSize = 100;
        this.bucketsList = new ArrayList<>(bucketListSize);
        fillWithData();
    }

    private void fillWithData() {
        IntStream.range(0, bucketListSize)
                .mapToObj((i) -> {
                    User user = User.builder()
                            .firstName("Name #" + i)
                            .lastName("Surname #" + i)
                            .email("name#" + i + "@mail.com")
                            .password("pass-" + i)
                            .role(UserRole.USER.toString())
                            .build();

                    Product product = Product.builder()
                            .name("Phone #"+i)
                            .description("New phone.")
                            .price((double) i*100)
                            .build();

                    return new Bucket(user, product, LocalDateTime.now());
                })
                .forEach((bucket) -> {
                    this.bucketsList.add(bucket);
                    this.bucketService.save(bucket);
                });
    }

    @AfterEach
    void tearDown() {
        bucketService.deleteAll();
        userService.deleteAll();
        productService.deleteAll();
    }

    @Test
    void existByProductId() {
        int randomId = new Random().nextInt(bucketsList.size());
        Integer productId = this.bucketsList.get(randomId).getProduct().getId();

        boolean exist = bucketService.existsByProductId(productId);
        assertTrue(exist);
    }

    @Test
    void findProductByUserId() {
        User user = User.builder()
                .firstName("Name")
                .lastName("Surname")
                .email("name@mail.com")
                .password("pass")
                .role(UserRole.USER.toString())
                .build();

        Product product = Product.builder()
                .name("Phone")
                .description("New phone.")
                .price((double)100)
                .build();

        userService.save(user);
        productService.save(product);

        int iterations = 10;
        IntStream.range(0, iterations)
                .mapToObj((i) -> new Bucket(user, product, LocalDateTime.now()))
                .forEach(bucketService::save);

        List<Product> productByUserId = bucketService.findProductsByUserId(user.getId());

        int actual = productByUserId.size();
        assertEquals(iterations, actual);
    }

    @Test
    void deleteByUserIdAndProductId() {
        int userId = 1;
        int productId = 1;

        bucketService.deleteByUserIdAndProductId(userId, productId);

        boolean isDeleted = bucketService.existsByUserIdAndProductId(userId, productId);
        assertFalse(isDeleted);
    }

}