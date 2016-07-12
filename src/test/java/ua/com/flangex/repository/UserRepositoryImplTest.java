package ua.com.flangex.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.com.flangex.model.*;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
})
@WebAppConfiguration
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void runOnce() {
        user = new User(
                "Eugene",
                "Deyneka",
                23,
                "deyneko55@gmail.com",
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
                Role.ROLE_ADMIN);
    }

    @Test
    public void saveTest() {
        userRepository.save(user);
        User result = userRepository.getByEmail("deyneko55@gmail.com");
        Assert.assertEquals(user, result);
    }

    @Test
    public void getTest(){
        User result = userRepository.get(1);
        Assert.assertEquals(result, user);
    }

    @Test(expected = NullPointerException.class)
    public void getNotExistingUserTest(){
        User result = userRepository.get(10);
        result.getEmail();
    }

    @Test
    public void getByEmailTest(){
        User result = userRepository.getByEmail("deyneko55@gmail.com");
        Assert.assertEquals(result, user);
    }

    @Test(expected = NullPointerException.class)
    public void getByEmailNotExistingUserTest(){
        User result = userRepository.getByEmail("deyneko1992@gmail.com");
        result.getEmail();
    }
}
