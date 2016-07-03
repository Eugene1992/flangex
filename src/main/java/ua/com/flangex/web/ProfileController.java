package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.flangex.repository.UserRepository;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    final static Logger logger = Logger.getLogger(ProfileController.class);

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, ModelMap model){
        logger.info("GET user " + id + "profile");
        model.addAttribute("user", userRepository.get(id));
        return "user-profile";
    }

    @RequestMapping("/profile")
    public String userProfile(ModelMap modelMap){
        logger.info("GET personal profile");
        modelMap.addAttribute("usersList", userRepository.getAll());
        return "personal-profile";
    }
}
