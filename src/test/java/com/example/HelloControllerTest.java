package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hillaryskye on 2/18/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)

public class HelloControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testHIllaryPage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hillary");
        this.mvc.perform(get("/hillary?querystring=HIllary"))
                .andExpect(status().isOk());
    }

    @Test
    public void testIndividualPage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/individual");
        this.mvc.perform(get("/individual?filter=hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void testExamplePage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/map-example");
        this.mvc.perform(get("/map-example?querystring=hi"));
    }
}
