package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.flangex.model.NativeLanguage;
import ua.com.flangex.model.PracticingLanguage;
import ua.com.flangex.model.User;
import ua.com.flangex.service.UserService;

import java.util.List;

/**
 * Admin page controller.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see UserService
 * @see Logger
 */
@Controller
public class AdminController {

    final static Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    /**
     * Remove user by id path variable.
     * @param id - user identifier
     * @return redirect to Apache Tiles 'profile' definition
     */
    @RequestMapping(value ="/remove/{id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") int id){
        logger.info("remove user " + id);
        userService.delete(id);
        return "redirect:/profile";
    }

    /**
     * Update user by id path variable.
     * @param id - user identifier
     * @param user - updated {@link User} instance
     * @param result - validation support instance
     * @return redirect to Apache Tiles 'profile' definition
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user, BindingResult result){
        logger.info("update user " + id);
        userService.update(user);
        return "redirect:/profile";
    }
}
