package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.flangex.model.Country;
import ua.com.flangex.model.Language;
import ua.com.flangex.model.User;
import ua.com.flangex.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class ProfileController {

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @Autowired
    private UserService userService;

    final static Logger logger = Logger.getLogger(ProfileController.class);

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, ModelMap model){
        logger.info("GET user " + id + "profile");
        model.addAttribute("user", userService.get(id));
        return "user-profile";
    }

    @RequestMapping("/profile")
    public String userProfile(ModelMap modelMap, Principal principal){
        logger.info("GET personal profile");
        modelMap.addAttribute("usersList", userService.getAll());
        modelMap.addAttribute("authUser", userService.getByEmail(principal.getName()));
        modelMap.addAttribute("countryList", Country.getCountries());
        modelMap.addAttribute("languageList", Language.getLanguages());
        return "personal-profile";
    }

    @RequestMapping("/profile-delete/{id}")
    public String deleteProfile(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        userService.delete(id);
        return "redirect:/";
    }
}
