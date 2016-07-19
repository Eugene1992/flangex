package ua.com.flangex.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * About the project page controller.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 */
@Controller
public class AboutController {

    /**
     * Return Apache Tiles 'about' definition by '/about' GET request.
     * @return Apache Tiles 'about' definition
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
}
