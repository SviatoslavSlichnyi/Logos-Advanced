package ua.lviv.magazine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.magazine.entity.Role;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.enumeration.UserRole;
import ua.lviv.magazine.service.UserService;

import java.security.Principal;

@RequiredArgsConstructor

@Controller
@Slf4j
public class LoginDispatcherController {

    private final UserService userService;

    @GetMapping("/login/dispatcher")
    public String dispatch(Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);

        if (user.getRoles().contains(new Role(UserRole.ROLE_ADMIN))) {
            return "redirect:/admin/create-product";
        }
        else {
            return "redirect:/cabinet";
        }
    }


}
