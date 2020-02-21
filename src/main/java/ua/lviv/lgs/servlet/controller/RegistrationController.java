package ua.lviv.lgs.servlet.controller;

import ua.lviv.lgs.servlet.entity.User;
import ua.lviv.lgs.servlet.service.UserService;
import ua.lviv.lgs.servlet.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private UserService userService;

    public RegistrationController() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userService.save(new User(firstName, lastName, email, password));
        resp.sendRedirect("login");
    }
}
