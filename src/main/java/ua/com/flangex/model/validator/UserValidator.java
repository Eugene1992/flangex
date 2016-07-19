package ua.com.flangex.model.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.flangex.model.User;
import ua.com.flangex.repository.UserRepository;

/**
 * Class provide validation behavior for the {@link User} by implementing the
 * following two methods ({@link Validator#supports}, {@link Validator#validate})
 * of the interface {@link org.springframework.validation.Validator}.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 * @see org.springframework.validation.Validator
 */
@Component
public class UserValidator implements Validator{

    /**
     * Injected repository instance, which provide CRUD operations for {@link User} entity.
     * @see User
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Register which {@code Class} must support the validation.
     * @param aClass the {@link Class} that this {@link UserValidator} is being asked if it
     * can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code aClass}
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    /**
     * Method which actually performs the validation. Here we describe the validation rules,
     * but rather in which case the data will not be considered valid.
     * @param obj the object that is to be validated
     * @param errors contextual state about the validation process
     * @see ValidationUtils
     */
    @Override
    public void validate(Object obj, Errors errors) {

        User user = (User)obj;

        String email = user.getEmail();
        String password = user.getPassword();
        String confirmedPassword = user.getConfirmedPassword();
        int passLength = password.length();

        if (passLength > 0 && passLength < 6 || passLength > 20){
            errors.rejectValue("password", "validation.length.password");
        } else if(passLength > 0 && !(password.equals(confirmedPassword))){
            errors.rejectValue("password", "validation.notmatch.password");
        }

        if (userRepository.getByEmail(email) != null) {
            errors.rejectValue("email", "validation.registered.email");
        }
    }
}
