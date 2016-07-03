package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.flangex.model.User;

import java.security.Principal;
import java.util.Locale;

@Controller
public class HomeController {

    final static Logger logger = Logger.getLogger(HomeController.class);

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error) {
        logger.info("GET home page");
        ModelAndView model = new ModelAndView();
        if (error != null) {
            logger.error("invalid username or password");
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView aceessDenied(Principal user){
        ModelAndView model = new ModelAndView();
        logger.error("GET access denied");
        if (user != null) {
            model.addObject("errorMessage", user.getName() + "You have no access to this page");
        } else {
            model.addObject("errorMessage", "You have no access to this page");
        }
        model.setViewName("access-denied");
        return model;
    }
}
