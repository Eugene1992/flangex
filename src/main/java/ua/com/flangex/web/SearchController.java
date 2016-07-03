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
import ua.com.flangex.model.User;
import ua.com.flangex.repository.UserRepository;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;

    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    SessionFactory sessionFactory;

    final static Logger logger = Logger.getLogger(SearchController.class);

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(){
        logger.info("GET search page");
        return "search";
    }

    @RequestMapping(value = "/searching", method = RequestMethod.GET)
    public String searching(ModelMap model,
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

        model.addAttribute("usersList", userRepository.getAllByCriteria(firstname));
        return "search";
    }
}
