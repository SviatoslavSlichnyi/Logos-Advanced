package ua.lviv.lgs.servlet.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.servlet.service.UserService;
import ua.lviv.lgs.servlet.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.time.LocalTime;

@WebFilter(urlPatterns = "/*",
        initParams = @WebInitParam(name = "test-param", value = "Base filter"))
public class LogFilter implements Filter {

    private final UserService userService;

    public LogFilter() {
        this.userService = UserServiceImpl.getInstance();
    }

    private final Logger log = Logger.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter " + filterConfig.getFilterName());
        String initParameter = filterConfig.getInitParameter("test-param");
        log.info("test param " + initParameter);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("do filter");
        String ipAddress = request.getRemoteAddr();
        // Log the IP address and current timestamp.
        log.debug("IP " + request.getRemoteAddr() + ", Time " + LocalTime.now());
        log.debug("IP local " + request.getLocalAddr() + ", Time " + LocalTime.now());
        log.debug("is secure" + request.isSecure());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
