package ua.com.flangex.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.NativeLanguage;
import ua.com.flangex.model.PracticingLanguage;
import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;
import ua.com.flangex.repository.UserRepository;
import java.util.List;

/**
 * {@link UserService} implementation which provide business logic operations.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see UserService
 * @see UserRepository
 * @see SessionFactory
 * @see User
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Delegating into {@link UserRepository#save(User)}
     * @param user - saved {@link User} instance
     */
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Fix duplicate language instances store into database. Previous duplicates
     * located in first index of language list which we are cut and save new values.
     * Delegating into {@link UserRepository#update(User)
     * @param user - saved {@link User} instance
     */
    @Override
    public void update(User user) {
        List<NativeLanguage> nl = user.getNativeLanguages().subList(1, user.getNativeLanguages().size());
        user.setNativeLanguages(nl);
        List<PracticingLanguage> pl = user.getPracticingLanguages().subList(1, user.getPracticingLanguages().size());
        user.setPracticingLanguages(pl);
        userRepository.update(user);
    }

    /**
     * Delegating into {@link UserRepository#delete(int)}
     */
    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    /**
     * Delegating into {@link UserRepository#get(int)}
     */
    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    /**
     * Delegating into {@link UserRepository#getByEmail(String)}
     */
    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    /**
     * Delegating into {@link UserRepository#getAll()}}
     */
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Create {@link Query} for {@link UserRepository#getAllByQuery(Query)}
     * by String concat using {@link StringBuilder}. Firstly append inner joins for
     * native and practicing languages cause they are required. Then check
     * {@link UserSearchParameters} properties for empty or value which means
     * same (like 'Both' in gender). If property is not empty - concat it to query string.
     * When query string is ready - create {@link Query} instance on the basis of it.
     * Then we check formed query string for params again and if it consist current param -
     * set the appropriate value to {@link Query} instance.
     * @param usp - consist search parameters values(including empty) from search form
     * @return
     */
    @Override
    @Transactional
    public List<User> createSearchQuery(UserSearchParameters usp) {
        StringBuilder querySB = new StringBuilder("FROM User u ");
        querySB.append("INNER JOIN u.nativeLanguages nl WITH nl.name = :nativeLang ");
        querySB.append("INNER JOIN u.practicingLanguages pl WITH pl.name = :practicingLang ");
        querySB.append("WHERE ");

        if (!usp.getFirstName().isEmpty()){
            querySB.append("u.firstname = :firstname AND ");
        }

        if (!usp.getLastName().isEmpty()){
            querySB.append("u.lastname = :lastname AND ");
        }

        if (!usp.getCountry().isEmpty()){
            querySB.append("u.country = :country AND ");
        }

        if (!usp.getCity().isEmpty()){
            querySB.append("u.city = :city AND ");
        }

        if (!usp.getAgeFrom().isEmpty()){
            querySB.append("u.age > :ageFrom AND ");
        }

        if (!usp.getAgeTo().isEmpty()){
            querySB.append("u.age < :ageTo AND ");
        }

        if (!usp.getGender().isEmpty() && !usp.getGender().equals("Both")){
            querySB.append("u.gender = :gender AND ");
        }

        if (!(usp.getFacebookCheck() == null)){
            querySB.append("u.facebookLink != '' AND "); // cause populate users got empty values in socials fields
        }

        if (!(usp.getTwitterCheck() == null)){
            querySB.append("u.twitterLink != '' AND ");
        }

        if (!(usp.getGooglePlusCheck() == null)){
            querySB.append("u.googlePlusLink != '' AND ");
        }

        if (!(usp.getVkontakteCheck() == null)){
            querySB.append("u.vkontakteLink != '' AND ");
        }

        if (!(usp.getLinkedinCheck() == null)){
            querySB.append("u.linkedInLink != '' AND ");
        }

        if (!(usp.getInstagramCheck() == null)){
            querySB.append("u.instagramLink != '' AND ");
        }

        String queryString = querySB.toString();

        if (queryString.endsWith("AND ")) {
            queryString = queryString.substring(0, queryString.length() - 5);
        }

        Query query = sessionFactory.getCurrentSession().createQuery(queryString);

        query.setParameter("nativeLang", usp.getNativeLanguage());
        query.setParameter("practicingLang", usp.getPracticingLanguage());

        if (queryString.contains("firstname")){
            query.setParameter("firstname", usp.getFirstName());
        }

        if (queryString.contains("lastname")){
            query.setParameter("lastname", usp.getLastName());
        }

        if (queryString.contains("country")){
            query.setParameter("country", usp.getCountry());
        }

        if (queryString.contains("city")){
            query.setParameter("city", usp.getCity());
        }

        if (queryString.contains("ageFrom")){
            int ageFrom = Integer.parseInt(usp.getAgeFrom());
            query.setParameter("ageFrom", ageFrom);
        }

        if (queryString.contains("ageTo")){
            int ageTo = Integer.parseInt(usp.getAgeTo());
            query.setParameter("ageTo", ageTo);
        }

        if (queryString.contains("gender")){
            query.setParameter("gender", usp.getGender());
        }

        List<User> users = userRepository.getAllByQuery(query);

        return users;
    }
}
