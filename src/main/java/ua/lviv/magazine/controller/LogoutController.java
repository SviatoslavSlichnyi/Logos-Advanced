package ua.lviv.magazine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LogoutController {

    @GetMapping("/logout")
    public String doLogout() {
        log.info("GET: logout form session");

//        req.getSession().invalidate();
        return "redirect:login";
    }

}
