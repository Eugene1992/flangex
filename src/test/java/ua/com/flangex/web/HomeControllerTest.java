package ua.com.flangex.web;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class HomeControllerTest extends AbstractWebTestController{

    /**
     * Return home page without 'error' request param.
     * @throws Exception
     */
    @Test
    public void homeTest() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/home.jsp"))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }

    /**
     * Return home page with 'error' request param.
     * If this option is present we have an additional 'error' parameter in
     * the model.
     * @throws Exception
     */
    @Test
    public void homeWithRequestErrorParamTest() throws Exception {
        mockMvc.perform(get("/").param("error", "value"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/home.jsp"))
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attributeExists("countryList"))
                .andExpect(model().attributeExists("languageList"));
    }
}
