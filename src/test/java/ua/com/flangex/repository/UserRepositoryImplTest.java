package ua.com.flangex.repository;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.com.flangex.model.NativeLanguage;
import ua.com.flangex.model.PracticingLanguage;
import ua.com.flangex.model.Role;
import ua.com.flangex.model.User;

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
                Arrays.asList(),
                Arrays.asList()
        );
    }

    @Test
    public void saveTest() {
        //User savedUser = userRepository.save(user);
        //Assert.assertEquals(user, savedUser);
    }

    @Test
    public void getTest(){
        User user = userRepository.getByUsername("Eugene");
        System.out.println(user);
        Assert.assertEquals(user, null);
    }


}
