package ua.lviv.lgs.servlet.controller;

import org.apache.log4j.Logger;
import ua.lviv.lgs.servlet.entity.User;
import ua.lviv.lgs.servlet.service.UserService;
import ua.lviv.lgs.servlet.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(LoginController.class);
    private UserService userService;

    public LoginController() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        log.info("email: " + email + ", password: " + password);
        Optional<User> userOp = userService.findByEmail(email);
        if (userOp.isPresent()) {
            User user = userOp.get();
            log.info("user exists : " + user);
            if (user.getPassword().equals(password)) {
                log.info("password is correct");
                req.setAttribute("userEmail", email);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
