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

/**
 * User profile controller.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see Logger
 * @see User
 * @see UserService
 */
@Controller
public class ProfileController {

    final static Logger logger = Logger.getLogger(ProfileController.class);

    @ModelAttribute("user")
    public User construct(){
        return new User();
    }

    @Autowired
    private UserService userService;

    /**
     * Return Apache Tiles 'user-profile' definition by {@link User#id} path
     * variable.
     * Set selected user to model.
     * @param id - user identifier
     * @param model - model with selected user
     * @return Apache Tiles 'user-profile' definition
     */
    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, ModelMap model){
        logger.info("GET user " + id + "profile");
        model.addAttribute("user", userService.get(id));
        return "user-profile";
    }

    /**
     * Return Apache Tiles 'profile' definition by '/profile' request.
     * Set list of {@link Country} and {@link Language} values into a model
     * for form select options, 'authUser' to populate personal data for current
     * authorized user, 'usersList' to populate admin panel if user get ADMIN_ROLE.
     * @param modelMap - model with lists of required data for user profile
     * @param principal - special Spring Security object wich consist user credentials
     * @return
     */
    @RequestMapping("/profile")
    public String userProfile(ModelMap modelMap, Principal principal){
        logger.info("GET personal profile");
        modelMap.addAttribute("usersList", userService.getAll());
        modelMap.addAttribute("authUser", userService.getByEmail(principal.getName()));
        modelMap.addAttribute("countryList", Country.getCountries());
        modelMap.addAttribute("languageList", Language.getLanguages());
        return "personal-profile";
    }

    /**
     * Delete profile and logout from it if user decide push this option.
     * @param request - HttpRequest object
     * @param response - HttpResponse object
     * @param id - user identifier
     * @return redirect to home page
     */
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
