package ua.com.flangex.web;

import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AboutControllerTest extends AbstractWebTestController{

    /**
     * Return about the project page by '/about' GET request.
     * @throws Exception
     */
    @Test
    public void aboutTest() throws Exception {
        mockMvc.perform(get("/about"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("about"))
                .andExpect(forwardedUrl("/WEB-INF/views/template/about.jsp"));
    }
}
