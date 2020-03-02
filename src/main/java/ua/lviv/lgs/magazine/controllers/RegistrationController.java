package ua.lviv.lgs.magazine.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.magazine.domain.User;
import ua.lviv.lgs.magazine.service.UserService;
import ua.lviv.lgs.magazine.service.impl.UserServiceImpl;

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
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("get request");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("post request");

        String email = req.getParameter("email");

        Optional<User> fromDB = userService.findByEmail(email);
        if (fromDB.isPresent()) {
            resp.setStatus(422);
        } else {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String password = req.getParameter("password");
            User user = new User(email, password, firstName, lastName,  "USER");

            log.debug("create new user " + user);
            userService.save(user);
        }
    }
}
