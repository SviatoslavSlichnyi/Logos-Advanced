package ua.lviv.magazine.controller.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.service.UserService;

@RequiredArgsConstructor

@Component
public class UserValidator implements Validator {

    private static final int minPasswordLength = 8;

    private final UserService userService;

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

        if (userService.existsByEmail(user.getUsername())) {
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
