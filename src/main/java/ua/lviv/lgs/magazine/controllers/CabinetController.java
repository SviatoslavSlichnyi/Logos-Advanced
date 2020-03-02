package ua.lviv.lgs.magazine.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/cabinet")
public class CabinetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Object> emailObj = Optional.ofNullable(req.getSession().getAttribute("userName"));
        if (emailObj.isPresent()) {
            String email = String.valueOf(emailObj.get());
            req.setAttribute("userEmail", email);
        }


        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
    }
}
