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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginController.class);

    private final UserService userService;

    public LoginController() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: login.jsp page");

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("POST: verify login fields");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        log.debug("param \"email\": " + email);
        log.debug("param \"password\": " + password);

        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                log.info("email and password match");

                req.setAttribute("userEmail", email);

                HttpSession session = req.getSession();
                session.setAttribute("userEmail", email);
                session.setAttribute("userId", user.getId());
                session.setAttribute("role", user.getRole());

                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                log.info("email or password DO NOT match");
                resp.setStatus(401);
            }
        } else {
            log.info("such email \""+email+"\" was NOT found");
            resp.setStatus(404);
        }
    }
}
