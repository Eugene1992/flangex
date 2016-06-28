package ua.com.flangex.web;

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

    @RequestMapping("/user/{id}")
    public String updateUser(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("user", userRepository.get(id));
        return "user-profile";
    }

    @RequestMapping("/profile")
    public String userProfile(ModelMap modelMap){
        modelMap.addAttribute("usersList", userRepository.getAll());
        return "personal-profile";
    }
}
