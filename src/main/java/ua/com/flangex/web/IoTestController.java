package ua.com.flangex.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IoTestController {

    @RequestMapping("/io/load")
    public String getLinksPage(){
        return "io-load";
    }
}
