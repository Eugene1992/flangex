package ua.com.flangex.web;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class SearchControllerTest extends AbstractWebTestController{

    /**
     * Return search page by '/search' GET request.
     * @throws Exception
     */
    @Test
    public void searchTest() throws Exception {
        mockMvc.perform(get("/search"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("search"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/search.jsp"))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }

    /**
     * Return users by inserted search parameters.
     * @throws Exception
     */
    @Test
    public void searchingTest() throws Exception {
        mockMvc.perform(get("/searching")
                .param("firstname", user.getFirstname())
                .param("lastname", user.getLastname())
                .param("gender", user.getGender())
                .param("country", user.getCountry())
                .param("city", user.getCity())
                .param("age-from", String.valueOf(user.getAge() - 1))
                .param("age-to", String.valueOf(user.getAge() + 1))
                .param("practicing-language", user.getPracticingLanguages().get(0).getName())
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("search"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/search.jsp"))
                .andExpect(model().attributeExists("usersList"))
                .andExpect(model().attribute("usersList", hasItem(user)))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }
}
