package ua.com.flangex.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.User;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if(user != null){
            session.delete(user);
        }
        return true;
    }

    @Override
    public User get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        return personsList;
    }

    @Override
    public User getByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.email=?");
        query.setParameter(0, email);
        User user = (User)query.uniqueResult();
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllByQuery(Query query) {
        List<User> findedUsers = query.list();
        System.out.println(findedUsers);
        return findedUsers;
    }
}
