package ua.com.flangex.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;
import ua.com.flangex.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public List<User> createSearchQuery(UserSearchParameters usp) {
        StringBuilder querySB = new StringBuilder("FROM User u WHERE ");

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
