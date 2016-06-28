package ua.com.flangex.service;

import ua.com.flangex.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
