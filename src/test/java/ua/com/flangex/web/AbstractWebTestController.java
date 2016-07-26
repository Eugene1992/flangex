package ua.com.flangex.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import ua.com.flangex.model.*;
import ua.com.flangex.service.UserService;
import ua.com.flangex.service.UserServiceImpl;
import java.util.Arrays;

/**
 * An abstract class with the required settings for the execution of the
 * controllers tests.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db.xml"
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ActiveProfiles("hsql")
public abstract class AbstractWebTestController {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Autowired
    protected UserService userService;

    protected UserService userServiceMock;

    protected User user;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        userServiceMock = org.mockito.Mockito.mock(UserServiceImpl.class);

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
                Role.ROLE_ADMIN
        );

        userService.save(user);
    }
}
