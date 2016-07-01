package ua.com.flangex.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.User;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    final static Logger logger = LogManager.getLogger(UserRepositoryImpl.class);

    /*@PersistenceContext
    private EntityManager em;*/

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(User user) {
        /*if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }*/
        sessionFactory.getCurrentSession().persist(user);
        //sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        /*User ref = em.getReference(User.class, id);
        em.remove(ref);*/
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if(null != user){
            session.delete(user);
        }
        return true;
    }

    @Override
    public User get(int id) {
        //return em.find(User.class, id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public List<User> getAll() {
        //return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        return personsList;
    }

    @Override
    public User getByCredentials(String email, String password) {
        //return em.createNamedQuery(User.BY_CREDENTIALS, User.class).setParameter(1, email).setParameter(2, password).getSingleResult();
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.email=? AND u.password=?");
        query.setParameter(0, email);
        query.setParameter(1, password);
        return (User)query.uniqueResult();
    }

    @Override
    public User getByUsername(String email) {
        //return em.createNamedQuery(User.BY_USERNAME, User.class).setParameter(1, email).getSingleResult();
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.email=?");
        query.setParameter(0, email);
        User user = (User)query.uniqueResult();
        System.out.println(user.getEmail() + " " + user.getPassword());
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllByCriteria(String string) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("firstname", string));
        List<User> users = (List<User>)criteria.list();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
