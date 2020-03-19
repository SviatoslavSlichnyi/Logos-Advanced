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
import java.util.List;

@WebServlet(urlPatterns = {"/admin/products", "/admin/products/*"})
public class AdminProductsController extends HttpServlet {

    private static final Logger log = Logger.getLogger(ua.lviv.lgs.controllers.ProductsController.class);

    private final BucketService bucketService;
    private final ProductService productService;

    public AdminProductsController() {
        this.bucketService = BucketServiceImpl.getInstance();
        this.productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: get products list");

        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        log.info("DELETE: remove product from list");

        int productId = Integer.parseInt(req.getPathInfo().substring(1));

        if (bucketService.containsProductById(productId)) {
            resp.setStatus(403);
            return;
        }

        productService.delete(productId);
    }
}
