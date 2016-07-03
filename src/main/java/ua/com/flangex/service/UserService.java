package ua.com.flangex.service;

import org.hibernate.Query;
import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;

import java.util.List;

public interface UserService {
    User save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();

    List<User> createSearchQuery(UserSearchParameters usp);
}
