package ua.com.flangex.web;

import org.junit.Test;
import ua.com.flangex.model.Country;
import ua.com.flangex.model.Language;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class ProfileControllerTest extends AbstractWebTestController{

    @Test
    public void getUserTest() throws Exception {

        when(userServiceMock.get(user.getId())).thenReturn(user);

        mockMvc.perform(get("/user/{id}", user.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("user-profile"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/user-profile.jsp"))
                .andExpect(model().attribute("user", hasProperty("id", is(user.getId()))))
                .andExpect(model().attribute("user", hasProperty("firstname", is(user.getFirstname()))))
                .andExpect(model().attribute("user", hasProperty("gender", is(user.getGender()))));
    }

    @Test
    public void getUserProfileTest() throws Exception {

        mockMvc.perform(get("/profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("personal-profile"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/personal-profile.jsp"))
                .andExpect(model().attribute("usersList", hasSize(1)))
                .andExpect(model().attribute("usersList", hasItem(
                        allOf(
                                hasProperty("id", is(user.getId())),
                                hasProperty("gender", is(user.getGender()))
                        )
                )))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }

    @Test
    public void deleteProfileTest() throws Exception {
        mockMvc.perform(get("/profile-delete/{id}", user.getId()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/home.jsp"));

    }

}
