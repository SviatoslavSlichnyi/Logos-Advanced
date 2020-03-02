package ua.lviv.lgs.magazine.controllers.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    public static final Logger log = Logger.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession().isNew()) {
            doRedirect(req, resp, "/login");
            return;
        }

        Optional<Object> roleOpt = Optional.ofNullable(req.getSession().getAttribute("role"));
        if (roleOpt.isPresent()) {
            String role = (String) roleOpt.get();
            if (!role.equalsIgnoreCase("admin")) {
                resp.setStatus(402);
                return;
            }
        } else {
            doRedirect(req, resp, "/login");
            return;
        }

        chain.doFilter(request, response);
    }

    private void doRedirect(HttpServletRequest req, HttpServletResponse resp, String path) {
        log.debug("Redirect to login");
        try {
            resp.sendRedirect(req.getContextPath() + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
