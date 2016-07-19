package ua.com.flangex.service;

import org.hibernate.Query;
import ua.com.flangex.model.User;
import ua.com.flangex.model.UserSearchParameters;
import java.util.List;

/**
 * Define business logic operations for {@link User}.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 */
public interface UserService {

    /**
     * Save {@link User} instance.
     * @param user - saved {@link User} instance
     */
    void save(User user);

    /**
     * Update {@link User} instance.
     * @param user - updated {@link User} instance
     */
    void update(User user);

    /**
     * Delete {@link User} from repository by {@link User#id}.
     * @param id - deleted {@link User} instance {@link User#id}
     */
    void delete(int id);

    /**
     * Get {@link User} by {@link User#id}.
     * @param id - {@link User} instance {@link User#id}
     * @return {@link User} instance
     */
    User get(int id);

    /**
     * Get {@link User} by {@link User#email}.
     * @param email - {@link User} instance {@link User#email}
     * @return {@link User} instance
     */
    User getByEmail(String email);

    /**
     * Get all users.
     * @return List of {@link User} instances
     */
    List<User> getAll();

    /**
     * Create {@link org.hibernate.Query} instance for
     * {@link ua.com.flangex.repository.UserRepository#getAllByQuery(Query)} and
     * return List of users by incoming {@link UserSearchParameters} object
     * which transmitting values of user search parameters from search form.
     * @param usp - consist search parameters values(including empty) from search form
     * @return - List of users by formed query
     */
    List<User> createSearchQuery(UserSearchParameters usp);
}
