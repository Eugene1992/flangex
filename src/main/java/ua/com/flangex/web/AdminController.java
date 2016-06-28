package ua.com.flangex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.flangex.repository.UserRepository;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        userRepository.delete(id);
        return "redirect:/profile";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        userRepository.delete(id);
        return "redirect:/profile";
    }
}
