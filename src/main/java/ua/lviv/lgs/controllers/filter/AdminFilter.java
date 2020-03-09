package ua.lviv.lgs.controllers.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.service.tool.FilterTool;
import ua.lviv.lgs.service.tool.impl.FilterToolImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    private final Logger log = Logger.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filtering...");
        FilterTool filterTool = new FilterToolImpl(request, response);

        if (filterTool.isAuthorized() && filterTool.isAuthorizedAs("ADMIN")) {
            log.debug("user's role: ADMIN");
            chain.doFilter(request, response);
            return;
        }

        log.debug("user is NOT authorized or DON'T have admin access.");
        ((HttpServletResponse) response).setStatus(402);
    }



    @Override
    public void destroy() {

    }
}
