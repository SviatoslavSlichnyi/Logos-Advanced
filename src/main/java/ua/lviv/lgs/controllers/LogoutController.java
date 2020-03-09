package ua.lviv.lgs.controllers;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    private final Logger log = Logger.getLogger(LogoutController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        log.info("get request");
        req.getSession().invalidate();
        resp.setStatus(200);
    }
}
