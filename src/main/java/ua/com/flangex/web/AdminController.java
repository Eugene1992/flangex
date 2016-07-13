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

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    final static Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        logger.info("remove user " + id);
        userService.delete(id);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user, BindingResult result){
        logger.info("update user " + id);
        List<NativeLanguage> nl = user.getNativeLanguages().subList(1, user.getNativeLanguages().size());
        user.setNativeLanguages(nl);
        List<PracticingLanguage> pl = user.getPracticingLanguages().subList(1, user.getPracticingLanguages().size());
        user.setPracticingLanguages(pl);
        userService.update(user);
        return "redirect:/profile";
    }
}
