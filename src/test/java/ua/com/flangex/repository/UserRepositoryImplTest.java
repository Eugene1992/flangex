package ua.com.flangex.repository;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.*;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
})
@ActiveProfiles("hsql")
public class UserRepositoryImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserRepository userRepository;

    private User user;

    private String email;

    @Before
    public void setUp() {
        email = "deyneko" + (int)(Math.random()*10000) + "@gmail.com";
        user = new User(
                "Eugene",
                "Deyneka",
                23,
                email,
                "26121992",
                "26121992",
                "Male",
                "Ukraine",
                "Kiev",
                Arrays.asList(
                        new NativeLanguage(Language.UKRAINIAN.name()),
                        new NativeLanguage(Language.RUSSIAN.name())
                ),
                Arrays.asList(
                        new PracticingLanguage(Language.ENGLISH.name()),
                        new PracticingLanguage(Language.SPANISH.name())
                ),
                "London is a capital of Great Britain!",
                Role.ROLE_ADMIN
        );
        userRepository.save(user);
    }

    @Test
    public void saveTest() {
        User result = userRepository.getByEmail(user.getEmail());
        Assert.assertEquals(user, result);
    }

    @Test
    public void getTest(){
        User result = userRepository.get(user.getId());
        Assert.assertEquals(result, user);
    }

    @Test
    public void getAllTest(){
        List<User> result = userRepository.getAll();
        Assert.assertNotNull(result);
    }

    @Test
    public void getNotExistingUserTest(){
        User result = userRepository.get(Integer.MAX_VALUE);
        Assert.assertNull(result);
    }

    @Test
    public void getByEmailTest(){
        User result = userRepository.getByEmail(user.getEmail());
        Assert.assertEquals(user, result);
    }

    @Test
    public void getByEmailNotExistingUserTest(){
        User result = userRepository.getByEmail(email);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        User takenUser = userRepository.getByEmail(email);
        String newEmail = "deyneko66@gmail.com";
        takenUser.setEmail(newEmail);
        userRepository.update(takenUser);
        User updatedUser = userRepository.getByEmail(newEmail);
        Assert.assertEquals(newEmail, updatedUser.getEmail());
    }

    @Test
    public void deleteTest(){
        userRepository.delete(user.getId());
        User result = userRepository.get(user.getId());
        Assert.assertNull(result);
    }

    @Test
    @Transactional
    public void getAllByQueryTest(){
        String queryString = "FROM User u WHERE u.id = :id";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("id", user.getId());
        List<User> result = userRepository.getAllByQuery(query);
        Assert.assertEquals(user, result.get(0));
    }
}
