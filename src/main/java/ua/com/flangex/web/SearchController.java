package ua.com.flangex.web;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.flangex.model.Role;
import ua.com.flangex.model.User;
import ua.com.flangex.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(){
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(ModelMap model,
           @RequestParam(value = "firstname", required = false) String firstname,
           @RequestParam(value = "lastname", required = false) String lastname,
           @RequestParam(value = "country", required = false) String country,
           @RequestParam(value = "city", required = false) String city,
           @RequestParam(value = "age-from", required = false) String ageFrom,
           @RequestParam(value = "age-to", required = false) String ageTo,
           @RequestParam(value = "gender", required = false) String gender,
           @RequestParam(value = "native-language", required = false) String nativeLanguage,
           @RequestParam(value = "practicing-language", required = false) String practicingLanguage,
           @RequestParam(value = "facebook-check", required = false) String facebookCheck,
           @RequestParam(value = "twitter-check", required = false) String twitterCheck,
           @RequestParam(value = "instagram-check", required = false) String instagramCheck,
           @RequestParam(value = "linkedin-check", required = false) String linkedinCheck,
           @RequestParam(value = "google-plus-check", required = false) String googlePlusCheck,
           @RequestParam(value = "vkontakte-check", required = false) String vkontakteCheck) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.where();

        model.addAttribute("usersList", Arrays.asList(new User("Eugene", "Deyneka", 23, "deyneko55@gmail.com", "2612", "2612", "Male", "Ukraine", "Kiev", null, null, "blablabla", Role.ROLE_USER)));
        return "search";
    }
}























//        System.out.println(firstname);
//        System.out.println(lastname);
//        System.out.println(country);
//        System.out.println(city);
//        System.out.println(ageFrom);
//        System.out.println(ageTo);
//        System.out.println(gender);
//        System.out.println(nativeLanguage);
//        System.out.println(practicingLanguage);
//        System.out.println(facebookCheck);
//        System.out.println(twitterCheck);
//        System.out.println(instagramCheck);
//        System.out.println(linkedinCheck);
//        System.out.println(googlePlusCheck);
//        System.out.println(vkontakteCheck);
