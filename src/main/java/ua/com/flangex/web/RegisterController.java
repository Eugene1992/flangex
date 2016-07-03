package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.flangex.model.Country;
import ua.com.flangex.model.Role;
import ua.com.flangex.model.User;
import ua.com.flangex.model.validator.UserValidator;
import ua.com.flangex.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserValidator validator;

    @Autowired
    private UserRepository userRepository;

    final static Logger logger = Logger.getLogger(RegisterController.class);

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid User user, BindingResult result) {
        user.setRole(Role.ROLE_ADMIN);
        validator.validate(user, result);
        if(result.hasErrors()) {
            logger.error("POST register form validation error");
            return "register";
        }
        userRepository.save(user);
        logger.info("save new user: " + user);
        String url = String.format("redirect:/register-success?name=%s&email=%s",
                user.getFirstname(),
                user.getEmail());
        return url;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap modelMap) {
        logger.info("GET register page");
        modelMap.addAttribute("countryList", Country.getCountryList());
        return "register";
    }

    @RequestMapping(value = "/register-success", method = RequestMethod.GET)
    public String successRegistration( @RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       ModelMap modelMap) {
        logger.info("GET successful registration page for user: " + email);
        modelMap.addAttribute("username", name);
        modelMap.addAttribute("email", email);
        return "successful-registration";
    }
}
