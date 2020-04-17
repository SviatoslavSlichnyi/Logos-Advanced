package ua.lviv.magazine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.magazine.controller.validator.UserValidator;
import ua.lviv.magazine.entity.Role;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.enumeration.UserRole;
import ua.lviv.magazine.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor

@Controller
@Slf4j
public class RegistrationController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.addRole(new Role(UserRole.ROLE_USER));
        userService.save(userForm);

        return "redirect:/login";
    }

}
