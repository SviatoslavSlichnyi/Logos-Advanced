package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/products")
public class AdminProductsController extends HttpServlet {

    private Logger log = Logger.getLogger(AdminProductsController.class);
    private ProductService productService;

    public AdminProductsController() {
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("get request for admin add product page");
        String role = (String) req.getSession().getAttribute("role");
        if (role != "ADMIN") {
            resp.setStatus(403);
        }
        req.getRequestDispatcher("/create-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = (String) req.getSession().getAttribute("role");
        if (role != "ADMIN") {
            resp.setStatus(403);

        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        if (isDavaValid(name, description, price)) {
            log.debug(" data is valid");
            Product product = new Product(name, description, Double.parseDouble(price));
            log.debug(" create new product");
            productService.save(product);
            resp.sendRedirect("products");
        }
    }

    private boolean isDavaValid(String name, String description, String price) {
        return name != null && description != null && price != null;
    }
}
