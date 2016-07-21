package ua.com.flangex.service;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.flangex.model.*;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
})
@ActiveProfiles("hsql")
public class UserServiceTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    private User user;

    private String email;

    @Before
    public void runOnce() {
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
                        new NativeLanguage(Language.UKRAINIAN.getLangName()),
                        new NativeLanguage(Language.RUSSIAN.getLangName())
                ),
                Arrays.asList(
                        new PracticingLanguage(Language.ENGLISH.getLangName()),
                        new PracticingLanguage(Language.SPANISH.getLangName())
                ),
                "London is a capital of Great Britain!",
                Role.ROLE_ADMIN
        );
        userService.save(user);
    }

    @Test
    public void saveTest() {
        User result = userService.getByEmail(user.getEmail());
        Assert.assertEquals(user, result);
    }

    @Test
    public void updateTest(){
        User takenUser = userService.getByEmail(email);
        String newEmail = "deyneko77@gmail.com";
        takenUser.setEmail(newEmail);
        userService.update(takenUser);
        User updatedUser = userService.getByEmail(newEmail);
        Assert.assertEquals(newEmail, updatedUser.getEmail());
    }

    @Test
    public void deleteTest(){
        userService.delete(user.getId());
        User result = userService.get(user.getId());
        Assert.assertNull(result);
    }

    @Test
    public void getTest(){
        User result = userService.get(user.getId());
        Assert.assertEquals(result, user);
    }

    @Test
    public void getByEmailTest(){
        User result = userService.getByEmail(user.getEmail());
        Assert.assertEquals(user, result);
    }

    @Test
    public void getByEmailNotExistingUserTest(){
        User result = userService.getByEmail(email);
        Assert.assertNotNull(result);
    }

    @Test
    public void getAllTest(){
        List<User> result = userService.getAll();
        Assert.assertNotNull(result);
    }

    /*@Test
    public void createSearchQueryByLanguagesTest(){
        UserSearchParameters usp = new UserSearchParameters(
                "", "", "", "", "", "", "",
                user.getNativeLanguages().get(0).getName(),
                user.getPracticingLanguages().get(0).getName(),
                null, null, null, null, null, null
        );
        List<User> users = userService.createSearchQuery(usp);
        System.out.println();
        boolean result = users.stream().anyMatch(u -> u.equals(user));
        Assert.assertTrue(result);
    }*/

}
