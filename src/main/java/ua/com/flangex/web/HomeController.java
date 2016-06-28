package ua.com.flangex.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.flangex.model.User;

import java.security.Principal;

@Controller
public class HomeController {

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView aceessDenied(Principal user){
        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("errorMessage", user.getName() + "You have no access to this page");
        } else {
            model.addObject("errorMessage", "You have no access to this page");
        }
        model.setViewName("access-denied");
        return model;
    }
}
