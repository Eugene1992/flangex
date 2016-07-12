package ua.com.flangex.service;

import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;
import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    List<User> createSearchQuery(UserSearchParameters usp);
}
