package ua.lviv.lgs.controllers.admin;

import org.apache.log4j.Logger;
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
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/admin/products", "/admin/products/*"})
public class AdminProductsController extends HttpServlet {

    private static final Logger log = Logger.getLogger(ua.lviv.lgs.controllers.ProductsController.class);
    private final ProductService productService;

    public AdminProductsController() {
        this.productService = ProductServiceImpl.getInstance();
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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("DELETE: delete product from full list");

        Integer productId = Integer.parseInt(req.getPathInfo().substring(1));
        log.debug("productId: " + productId);

        log.info("removing product...");
        try {
            productService.delete(productId);
        } catch (SQLException e) {
            resp.setStatus(500);
        }
    }
}
