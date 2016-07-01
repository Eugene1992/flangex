package ua.com.flangex.repository;

import org.hibernate.Criteria;
import ua.com.flangex.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();

    User getByCredentials(String email, String password);

    User getByUsername(String email);

    List<User> getAllByCriteria(String string);
}
