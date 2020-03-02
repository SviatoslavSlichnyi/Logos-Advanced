package ua.lviv.lgs.magazine.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.magazine.domain.Product;
import ua.lviv.lgs.magazine.service.ProductService;
import ua.lviv.lgs.magazine.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/create-product")
public class CreateProductsController extends HttpServlet {

    private Logger log = Logger.getLogger(CreateProductsController.class);
    private ProductService productService;

    public CreateProductsController() {
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("get request for admin add product page");
//        String role = (String) req.getSession().getAttribute("role");
//        if (!role.equals("ADMIN")) {
//            resp.setStatus(403);
//        }
        req.getRequestDispatcher("/admin/create-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("post request from admin");
//        String role = (String) req.getSession().getAttribute("role");
//        if (!role.equals("ADMIN")) {
//            resp.setStatus(403);
//
//        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        log.debug("name: " + name + "; "
                + "description: " + description + "; "
                + "price: " + price);

        if (isDataValid(name, description, price)) {
            log.debug(" data is valid");
            Product product = new Product(name, description, Double.parseDouble(price));
            log.debug(" create new product");
            productService.save(product);
            resp.sendRedirect("../products");
        } else {
            resp.setStatus(402);
        }
    }

    private boolean isDataValid(String name, String description, String price) {
        return name != null && description != null && price != null;
    }
}
