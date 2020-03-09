package ua.lviv.lgs.controllers;

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
import java.util.Optional;

@WebServlet("/cabinet")
public class CabinetController extends HttpServlet {

    private static final Logger log = Logger.getLogger(CabinetController.class);
    private BucketService bucketService;

    public CabinetController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: show the user selected products");
        Optional<Object> emailObj = Optional.ofNullable(req.getSession().getAttribute("userEmail"));
        Optional<Object> userIdObj = Optional.ofNullable(req.getSession().getAttribute("userId"));
        if (emailObj.isPresent() && userIdObj.isPresent()) {
            String email = String.valueOf(emailObj.get());
            req.setAttribute("userEmail", email);

            Integer userId = (Integer) userIdObj.get();
            log.debug("userId: " + userId);

            List<Product> products = bucketService.findProductsByUserId(userId);
            log.debug("products size: " + products.size());

            req.setAttribute("products", products);
        }
        else {
            throw new RuntimeException("email or userId attributes are NULL");
        }

        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
    }
}
