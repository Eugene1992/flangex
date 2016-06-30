package ua.com.flangex.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {

    final static Logger logger = LogManager.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        User ref = em.getReference(User.class, id);
        em.remove(ref);
        return true;
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        logger.debug("Get all users");
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }

    @Override
    public User getByCredentials(String email, String password) {
        return em.createNamedQuery(User.BY_CREDENTIALS, User.class).setParameter(1, email).setParameter(2, password).getSingleResult();
    }

    @Override
    public User getByUsername(String email) {
        return em.createNamedQuery(User.BY_USERNAME, User.class).setParameter(1, email).getSingleResult();
    }
}
