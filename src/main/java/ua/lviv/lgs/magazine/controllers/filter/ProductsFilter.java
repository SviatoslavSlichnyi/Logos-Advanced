package ua.lviv.lgs.magazine.controllers.filter;

import ua.lviv.lgs.magazine.service.LoginStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/products")
public class ProductsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginStatus loginStatus = new LoginStatus(request, response);

        if (!loginStatus.isAuthorized()) {
            loginStatus.redirectTo("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
