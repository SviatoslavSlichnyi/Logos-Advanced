package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {
    private final Logger log = Logger.getLogger(WelcomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("get request");
        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
    }
}
