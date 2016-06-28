package ua.com.flangex.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.flangex.model.User;

@Component
public class UserValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmedPassword",
                "required.confirmedPassword", "Field name is required.");

        User user = (User)obj;

        if(!(user.getPassword().equals(user.getConfirmedPassword()))){
            errors.rejectValue("password", "notmatch.password");
        }
    }
}
