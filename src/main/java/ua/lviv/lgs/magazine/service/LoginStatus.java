package ua.lviv.lgs.magazine.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Data
@NoArgsConstructor
public class LoginStatus {

    private  HttpServletRequest req;
    private HttpServletResponse resp;

    public LoginStatus(ServletRequest request, ServletResponse response) {
        this.req = (HttpServletRequest) request;
        this.resp = (HttpServletResponse) response;
    }

    public boolean isAuthorized() {
        HttpSession session = req.getSession();

        if (session.isNew()) {
            return false;
        }

        Optional<Object> userEmail = Optional.ofNullable(session.getAttribute("userEmail"));
        if (!userEmail.isPresent()) {
            return false;
        }

        return true;
    }

    public void redirectTo(String page) {
        try {
            resp.sendRedirect(req.getContextPath() + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
