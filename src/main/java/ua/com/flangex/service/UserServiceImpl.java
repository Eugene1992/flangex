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
            //query.setParameter("last_name", usp.getLastName());
        }

        if (!usp.getCountry().isEmpty()){
            querySB.append("u.country = :country AND ");
            //query.setParameter("country", usp.getCountry());
        }

        if (!usp.getCity().isEmpty()){
            querySB.append("u.city = :city AND ");
            //query.setParameter("city", usp.getCity());
        }

        if (usp.getAgeFrom() != 0){
            querySB.append("u.age > :ageFrom AND ");
            //query.setParameter("ageFrom", usp.getAgeFrom());
        }

        if (usp.getAgeTo() != 0){
            querySB.append("u.age < :ageTo");
            //query.setParameter("ageTo", usp.getAgeTo());
        }

        if (!usp.getCity().isEmpty()){
            querySB.append("u.city = :city");
           //query.setParameter("city", usp.getCity());
        }

        String queryString = querySB.toString();
        Query query  =  sessionFactory.getCurrentSession().createQuery(queryString);

        if (queryString.contains("firstname")){
            query.setParameter("firstname", usp.getFirstName());
        }

        if (queryString.contains("lastname")){
            query.setParameter("lastname", usp.getLastName());
        }

        List<User> users = userRepository.getAllByQuery(query);

        return users;
    }
}
