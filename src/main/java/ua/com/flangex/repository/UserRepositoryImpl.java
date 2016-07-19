package ua.com.flangex.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.User;
import java.util.List;

/**
 * {@link UserRepository} implementation which provides data operations
 * for user repository.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see UserRepository
 * @see User
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Save {@link User} into repository.
     * @param user - saved {@link User} instance
     */
    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    /**
     * Update {@link User} in repository.
     * @param user - updated {@link User} instance
     */
    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    /**
     * Update {@link User} from repository by {@link User#id}.
     * @param id - deleted {@link User} instance {@link User#id}
     * @return - true if user successfully deleted, or false - if not
     */
    @Override
    @Transactional
    public boolean delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if(user != null){
            session.delete(user);
            return true;
        } else return false;
    }

    /**
     * Get {@link User} from repository by {@link User#id}.
     * @param id - {@link User} instance {@link User#id}
     * @return {@link User} instance
     */
    @Override
    public User get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    /**
     * Get all users from repository.
     * @return List of {@link User} instances
     */
    @Override
    public List<User> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        return personsList;
    }

    /**
     * Get {@link User} from repository by {@link User#email}.
     * @param email - {@link User} instance {@link User#email}
     * @return {@link User} instance
     */
    @Override
    public User getByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.email=?");
        query.setParameter(0, email);
        User user = (User)query.uniqueResult();
        return user;
    }

    /**
     * Get users from repository by {@link Query}.
     * The formation of the query takes place in service layer.
     * @param query - {@link Query} instance
     * @return - List of filtered users by input query
     */
    @Override
    @Transactional
    public List<User> getAllByQuery(Query query) {
        List<User> findedUsers = query.list();
        System.out.println(findedUsers);
        return findedUsers;
    }
}
