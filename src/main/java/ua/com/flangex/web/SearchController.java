package ua.com.flangex.web;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.flangex.model.Country;
import ua.com.flangex.model.Language;
import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;
import ua.com.flangex.repository.UserRepository;
import ua.com.flangex.service.UserService;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    SessionFactory sessionFactory;

    final static Logger logger = Logger.getLogger(SearchController.class);

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(ModelMap modelMap){
        logger.info("GET search page");
        modelMap.addAttribute("countryList", Country.getCountries());
        modelMap.addAttribute("languageList", Language.getLanguages());
        return "search";
    }

    @RequestMapping(value = "/searching", method = RequestMethod.GET)
    public String searching(ModelMap modelMap,
           @RequestParam(value = "firstname", required = false)             String firstname,
           @RequestParam(value = "lastname", required = false)              String lastname,
           @RequestParam(value = "country", required = false)               String country,
           @RequestParam(value = "city", required = false)                  String city,
           @RequestParam(value = "age-from", required = false)              String ageFrom,
           @RequestParam(value = "age-to", required = false)                String ageTo,
           @RequestParam(value = "gender", required = false)                String gender,
           @RequestParam(value = "native-language", required = false)       String nativeLanguage,
           @RequestParam(value = "practicing-language", required = false)   String practicingLanguage,
           @RequestParam(value = "facebook-check", required = false)        String facebookCheck,
           @RequestParam(value = "twitter-check", required = false)         String twitterCheck,
           @RequestParam(value = "instagram-check", required = false)       String instagramCheck,
           @RequestParam(value = "linkedin-check", required = false)        String linkedinCheck,
           @RequestParam(value = "google-plus-check", required = false)     String googlePlusCheck,
           @RequestParam(value = "vkontakte-check", required = false)       String vkontakteCheck) {

        UserSearchParameters usp = new UserSearchParameters(
                firstname,
                lastname,
                country,
                city,
                ageFrom,
                ageTo,
                gender,
                nativeLanguage,
                practicingLanguage,
                facebookCheck,
                twitterCheck,
                instagramCheck,
                linkedinCheck,
                googlePlusCheck,
                vkontakteCheck
        );

        //userService.createSearchQuery(usp);

        modelMap.addAttribute("usersList", userService.createSearchQuery(usp));
        modelMap.addAttribute("countryList", Country.getCountries());
        modelMap.addAttribute("languageList", Language.getLanguages());
        return "search";
    }
}
