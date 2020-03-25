package ua.lviv.magazine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.UnprocessableEntityResponse;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.service.UserService;

import java.util.Optional;

@Controller
@Slf4j
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String registerUser(
            @RequestParam String email,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String password
    ) {
        log.info("POST: add user");

        log.debug("param \"email\": " + email);

        Optional<User> fromDB = userService.findByEmail(email);

        if (fromDB.isPresent()) {
            log.debug(email + " - this email is already registered");
            throw new UnprocessableEntityResponse();
        } else {
            log.debug("param \"firstName\": " + firstName);
            log.debug("param \"lastName\": " + lastName);
            log.debug("param \"password\": " + password);

            User user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(password)
                    .role("USER")
                    .build();

            userService.save(user);
        }

        return "redirect:login";
    }

}
