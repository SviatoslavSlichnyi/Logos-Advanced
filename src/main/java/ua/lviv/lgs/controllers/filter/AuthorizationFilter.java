package ua.lviv.lgs.controllers.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.service.tool.FilterTool;
import ua.lviv.lgs.service.tool.impl.FilterToolImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = {"/cabinet", "/products"})
public class AuthorizationFilter implements Filter {

    private final Logger log = Logger.getLogger(AdminFilter.class);
    private static final String LOGIN_PAGE = "/login";
    private FilterTool filterTool;


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filtering...");
        filterTool = new FilterToolImpl(request, response);

        if (!filterTool.isAuthorized()) {
            log.debug("user is NOT authorized.");
            filterTool.redirect(LOGIN_PAGE);
            return;
        }

        log.debug("user is authorized.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
