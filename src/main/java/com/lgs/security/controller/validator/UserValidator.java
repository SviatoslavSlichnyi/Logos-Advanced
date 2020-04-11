package com.lgs.security.controller.validator;

import com.lgs.security.entity.User;
import com.lgs.security.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private static final int minPasswordLength = 8;

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.name.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "user.password.not.empty");

        User user = (User) o;

        if (userService.existsByUsername(user.getUsername())) {
            errors.rejectValue("username",
                    "user.username.already-exists",
                    "User with username \""+user.getUsername()+"\" already exist.");
        }

        if (user.getPassword().isEmpty() ) {}
        else if (user.getPassword().length() < minPasswordLength) {
            errors.rejectValue("password", "userForm.size.password");
        }
        else if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "userForm.diff.passwordConfirm");
        }
    }
}
