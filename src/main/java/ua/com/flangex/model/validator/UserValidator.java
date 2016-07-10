package ua.com.flangex.model.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.flangex.model.User;
import ua.com.flangex.repository.UserRepository;

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User)obj;

        if(!(user.getPassword().equals(user.getConfirmedPassword()))){
            errors.rejectValue("password", "validation.notmatch.password");
        }

        if (userRepository.getByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "validation.registered.email");
        }
    }
}
