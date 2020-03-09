package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService;

    private final Logger log = Logger.getLogger(LoginController.class);

    public LoginController() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("get request");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("post request");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            log.debug("user is present: " + user);
            if (user.getPassword().equals(password)) {
                req.setAttribute("userEmail", email);
                req.getSession().setAttribute("userEmail", email);
                req.getSession().setAttribute("userId", user.getId());
                req.getSession().setAttribute("role", user.getRole());
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                log.debug("invalid password");
                resp.setStatus(401);
            }
        } else {
            log.debug("not found user with email: " + email);
            resp.setStatus(404);
        }
    }
}
