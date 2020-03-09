package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

    private static final Logger log = Logger.getLogger(ProductsController.class);
    private ProductService productService;
    private BucketService bucketService;

    public ProductsController() {
        this.productService = ProductServiceImpl.getInstance();
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("get products");

        List<Product> products = productService.findAll();
        log.debug("set products: " + products);
        req.setAttribute("products", products);

        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("add product to user list");

        String productIdStr = req.getParameter("productId");
        Integer productId = Integer.parseInt(productIdStr);
        Integer userId = (Integer) req.getSession().getAttribute("userId");

        LocalDateTime time = LocalDateTime.now();
        Bucket bucket = new Bucket(userId,productId, time);
        bucketService.save(bucket);
    }
}
