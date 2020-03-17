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

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private static final Logger log = Logger.getLogger(RegistrationController.class);

    private final UserService userService;

    public RegistrationController() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("GET: login page");

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("POST: add user");

        String email = req.getParameter("email");

        log.debug("param \"email\": " + email);

        Optional<User> fromDB = userService.findByEmail(email);
        if (fromDB.isPresent()) {
            log.debug(email + " - this email is already registered");
            resp.setStatus(422);
        } else {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String password = req.getParameter("password");

            log.debug("param \"firstName\": " + firstName);
            log.debug("param \"lastName\": " + lastName);
            log.debug("param \"password\": " + password);

            User user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(password)
                    .role("USER")
                    .build();

            userService.save(user);
        }
    }
}
