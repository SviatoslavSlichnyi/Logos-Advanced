package ua.lviv.magazine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.NotFoundResponse;
import ua.lviv.magazine.controller.response.UnauthorizedResponse;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.service.UserService;

import java.util.Optional;

@Controller
@Slf4j
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        log.debug("GET: login.jsp page");

        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password, Model model) {
        log.info("POST: verify login fields");

        log.debug("param \"email\": " + email);
        log.debug("param \"password\": " + password);

        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                log.info("email and password match");

                model.addAttribute("userEmail", email);

                return  "cabinet";
            } else {
                log.info("email or password DO NOT match");
                throw new UnauthorizedResponse();
            }
        } else {
            log.info("such email \""+email+"\" was NOT found");
            throw new NotFoundResponse();
        }
    }

}
