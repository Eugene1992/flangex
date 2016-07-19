package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.flangex.model.Country;
import ua.com.flangex.model.Language;
import ua.com.flangex.model.User;
import java.security.Principal;

/**
 * Hone project page controller.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see Logger
 */
@Controller
public class HomeController {

    final static Logger logger = Logger.getLogger(HomeController.class);

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    /**
     * Return Apache Tiles 'home' definition by '/' GET request.
     * Check the error request param, it will be not null when user get
     * bad login attempt.
     * Set list of {@link Country} and {@link Language} values into a model
     * for form select options.
     * @param error - bad user login attempt flag
     * @param modelMap - model with country and language lists
     * @return Apache Tiles 'home' definition
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
        logger.info("GET home page");
        if (error != null) {
            logger.error("invalid username or password");
            modelMap.addAttribute("error", "Invalid username or password!");
        }
        modelMap.addAttribute("countryList", Country.getCountries());
        modelMap.addAttribute("languageList", Language.getLanguages());
        return "home";
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
