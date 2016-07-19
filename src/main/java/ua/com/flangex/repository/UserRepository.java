package ua.com.flangex.repository;

import org.hibernate.Query;
import ua.com.flangex.model.User;
import java.util.List;

/**
 * Define data operations for user repository.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 */
public interface UserRepository {

    /**
     * Save {@link User} into repository.
     * @param user - saved {@link User} instance
     */
    void save(User user);

    /**
     * Update {@link User} in repository.
     * @param user - updated {@link User} instance
     */
    void update(User user);

    /**
     * Delete {@link User} from repository by {@link User#id}.
     * @param id - deleted {@link User} instance {@link User#id}
     * @return - true if user successfully deleted, or false - if not
     */
    boolean delete(int id);

    /**
     * Get {@link User} from repository by {@link User#id}.
     * @param id - {@link User} instance {@link User#id}
     * @return {@link User} instance
     */
    User get(int id);

    /**
     * Get all users from repository.
     * @return List of {@link User} instances
     */
    List<User> getAll();

    /**
     * Get {@link User} from repository by {@link User#email}.
     * @param email - {@link User} instance {@link User#email}
     * @return {@link User} instance
     */
    User getByEmail(String email);

    /**
     * Get users from repository by {@link Query}.
     * The formation of the query takes place in service layer.
     * @param query - {@link Query} instance
     * @return - List of filtered users by input query
     */
    List<User> getAllByQuery(Query query);
}
