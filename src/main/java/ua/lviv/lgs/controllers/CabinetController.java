package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/cabinet", "/cabinet/*"})
public class CabinetController extends HttpServlet {

    private static final Logger log = Logger.getLogger(CabinetController.class);

    private final BucketService bucketService;

    public CabinetController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: get list of user's products");

        Optional<Object> emailObj = Optional.ofNullable(req.getSession().getAttribute("userEmail"));
        Optional<Object> userIdObj = Optional.ofNullable(req.getSession().getAttribute("userId"));

        if (emailObj.isPresent() && userIdObj.isPresent()) {

            String email = String.valueOf(emailObj.get());
            int userId = (Integer) userIdObj.get();
            List<Product> products = bucketService.findProductsByUserId(userId);

            log.debug("email: " + email);
            log.debug("userId: " + userId);

            req.setAttribute("userEmail", email);
            req.setAttribute("products", products);
        }
        else {
            throw new RuntimeException("email or userId attributes are NULL");
        }

        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        log.info("DELETE: remove product from user list");

        int productId = Integer.parseInt(req.getPathInfo().substring(1));
        log.debug("product_id to delete: " + productId);

        Optional<Object> userIdObj = Optional.ofNullable(req.getSession().getAttribute("userId"));
        if (userIdObj.isPresent()) {
            int userId = (Integer) userIdObj.get();
            log.debug("product list of user_id: " + userId);

            bucketService.deleteByUserIdAndProductId(userId, productId);
        } else {
            log.error("userId is NULL");
        }
    }
}
