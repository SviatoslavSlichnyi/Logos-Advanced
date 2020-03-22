package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private final Logger log = Logger.getLogger(RegistrationController.class);

    private UserService userService;

    public RegistrationController() {
        userService = UserServiseImpl.getInstance();
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
        Optional<User> fromDB = userService.findByEmail(email);
        if (fromDB.isPresent()) {
            resp.setStatus(422);
        } else {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String password = req.getParameter("password");
            User user = new User(firstName, lastName, email, "USER", password);
            log.debug("create new user " + user);
            userService.save(user);
        }
    }
}
