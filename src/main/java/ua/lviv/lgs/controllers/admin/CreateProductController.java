package ua.lviv.lgs.controllers.admin;

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

@WebServlet("/admin/create-product")
public class CreateProductController extends HttpServlet {

    private Logger log = Logger.getLogger(CreateProductController.class);
    private ProductService productService;

    public CreateProductController() {
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("get request for admin add product page");
        req.getRequestDispatcher("/admin/create-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

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
