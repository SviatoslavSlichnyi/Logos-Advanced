package ua.lviv.lgs.magazine.controllers.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.magazine.service.LoginStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/cabinet")
public class CabinetFilter implements Filter {

    public static final Logger log = Logger.getLogger(CabinetFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginStatus loginStatus = new LoginStatus(request, response);

        if (!loginStatus.isAuthorized()) {
            log.debug("User is not logged in.");
            loginStatus.redirectTo("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
