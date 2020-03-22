package ua.lviv.lgs.controllers.filter;//package ua.lviv.lgs.controllers.filter;
//
//import org.apache.log4j.Logger;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.SplittableRandom;
//
//@WebFilter("/admin/*")
//public class AdmiAuthorityFilter implements Filter {
//
//    private final Logger log = Logger.getLogger(AdmiAuthorityFilter.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("init filter " + filterConfig.getFilterName());
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("filter log in");
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpSession session = httpRequest.getSession();
//        String loginURI = httpRequest.getContextPath() + "/login";
//        boolean isLoggedIn = session != null && session.getAttribute("userEmail") != null;
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
//
//        String role = (String) session.getAttribute("role");
//
//        if (isLoggedIn && role.equals("ADMIN")) {
//            httpRequest.getRequestDispatcher("cabinet.jsp").forward(request, response);
//        } else {
//            httpRequest.getRequestDispatcher("/login").forward(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        log.info("destroy");
//    }
//}
