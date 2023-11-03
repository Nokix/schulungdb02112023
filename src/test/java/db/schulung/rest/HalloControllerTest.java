package db.schulung.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HalloController.class)
class HalloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sayHello() throws Exception {
        MockHttpServletRequestBuilder get
                = MockMvcRequestBuilders.get("/hallo/gustav")
                .param("n", "4");

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("moin moin moin moin gustav"));
    }
}