package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

    private static final Logger log = Logger.getLogger(ProductsController.class);

    private final BucketService bucketService;
    private final UserService userService;
    private final ProductService productService;

    public ProductsController() {
        this.bucketService = BucketServiceImpl.getInstance();
        this.userService = UserServiceImpl.getInstance();
        this.productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: product list");

        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("POST: add product to user list");

        int productId = Integer.parseInt(req.getParameter("productId"));
        int userId = (int) req.getSession().getAttribute("userId");

        log.debug("param \"productId\": " + productId);
        log.debug("param \"userId\": " + userId);

        Optional<User> userOpt = userService.findById(userId);
        Optional<Product> productOpt = productService.findById(productId);

        if (!userOpt.isPresent() || !productOpt.isPresent()) {
            resp.setStatus(404);
            return;
        }

        User user = userOpt.get();
        Product product = productOpt.get();

        log.debug("formed bucket: \n" +
                user + "\n" +
                product);


        Bucket bucket = Bucket.builder()
                .user(user)
                .product(product)
                .purchaseDate(LocalDateTime.now())
                .build();

        bucketService.save(bucket);
    }
}
