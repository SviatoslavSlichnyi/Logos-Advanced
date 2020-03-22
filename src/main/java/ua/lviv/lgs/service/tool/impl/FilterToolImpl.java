package ua.lviv.lgs.service.tool.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.service.tool.FilterTool;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class FilterToolImpl implements FilterTool {

    private static final Logger log = Logger.getLogger(FilterTool.class);

    private HttpServletRequest req;
    private HttpServletResponse resp;

    public FilterToolImpl(ServletRequest request, ServletResponse response) {
        this.req = (HttpServletRequest) request;
        this.resp = (HttpServletResponse) response;
    }

    @Override
    public boolean isAuthorized() {

        HttpSession session = req.getSession();

        if (session.isNew()) {
            log.debug("session has been started.");
            return false;
        }

        Optional<Object> sessionStatus = Optional.ofNullable(session.getAttribute("role"));
        if (!sessionStatus.isPresent()) {
            log.debug("session is invalided.");
            return false;
        }

        log.debug("session is NOT a new. Session was started.");
        return true;
    }

    @Override
    public boolean isAuthorizedAs(String role) {
        HttpSession session = req.getSession();

        Optional<Object> userRole = Optional.ofNullable(session.getAttribute("role"));
        if (userRole.isPresent()) {
            String rol = (String) userRole.get();
            if (rol.equalsIgnoreCase("admin")) {
                return true;
            }

            log.debug("user's role is " + rol);
        } else {
            log.debug("attribute role was NOT found.");
        }

        return false;
    }

    @Override
    public void redirect(String page) {
        try {
            resp.sendRedirect(req.getContextPath() + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
