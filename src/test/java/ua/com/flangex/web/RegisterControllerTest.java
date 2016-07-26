package ua.com.flangex.web;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import ua.com.flangex.model.User;
import ua.com.flangex.util.TestUtil;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegisterControllerTest extends AbstractWebTestController{

    /**
     * Registration will be successful because the <b>firstname</b> parameter has a
     * valid length of 6 characters.
     * String of specified length generates by {@link TestUtil#createStringWithLength(int)}
     * @throws Exception
     * @see TestUtil
     */
    @Test
    public void registerSuccessTest() throws Exception {

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstname", "Eugene")
                .param("email", "deyneko55@gmail.com")
                .param("password", "26121992z")
        )
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/register.jsp"))
                .andExpect(model().attribute("id", is(nullValue())));

        ArgumentCaptor<User> formObjectArgument = ArgumentCaptor.forClass(User.class);
        verify(userServiceMock, times(1)).save(formObjectArgument.capture());
        verifyNoMoreInteractions(userServiceMock);

        User userObject = formObjectArgument.getValue();

        assertThat(userObject.getDescription(), is("description"));
        assertNull(userObject.getId());
        assertThat(userObject.getFirstname(), is("title"));
    }

    /**
     * Registration will be failed because the <b>firstname</b> parameter has a
     * length of 11 characters, and the valid length is 10.
     * String of specified length generates by {@link TestUtil#createStringWithLength(int)}
     * @throws Exception
     * @see TestUtil
     */
    @Test
    public void registerFirstnameFailedTest() throws Exception {
        String firstname = TestUtil.createStringWithLength(11);
        String email = user.getEmail();
        String password = user.getPassword();

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstname", firstname)
                .param("email", email)
                .param("password", password)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/register.jsp"))
                .andExpect(model().attributeHasFieldErrors("user", "firstname"))
                .andExpect(model().attribute("user", hasProperty("id", nullValue())))
                .andExpect(model().attribute("user", hasProperty("firstname", is(firstname))))
                .andExpect(model().attribute("user", hasProperty("email", is(email))));

        verifyZeroInteractions(userServiceMock);
    }

    /**
     * Return register page by '/register' GET request.
     * @throws Exception
     */
    @Test
    public void registerTest() throws Exception {
        mockMvc.perform(get("/register"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/register.jsp"))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }

    /**
     * Return register page by '/register' GET request.
     * @throws Exception
     */
    @Test
    public void successRegistrationTest() throws Exception {
        mockMvc.perform(get("/register-success")
                .param("name", user.getFirstname())
                .param("email", user.getEmail())
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("successful-registration"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/success-reg.jsp"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attributeExists("email"));
    }

}
