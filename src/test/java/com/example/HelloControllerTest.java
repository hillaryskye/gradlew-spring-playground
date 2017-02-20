package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    @Test
    public void testIndexEndpoint() throws Exception {
        int driverId = 4; // in real life you might pull this from a db.

        this.mvc.perform(get(String.format("/drivers/%d/trips", driverId)))
                .andExpect(status().isOk());
    }

    @Test
    public void testIndividualVariableParams() throws Exception {
        String q = "foo";
        String from = "bar";

        this.mvc.perform(get(String.format("/individual-example/%s/%s", q, from)))
                .andExpect((status().isOk()));

    }

    @Test
    public void testTaskVariablesEndPoint() throws Exception {
        int taskId = 1;
        int commentId = 23;

        this.mvc.perform(get(String.format("/test/tasks/%d/comments/%d", taskId, commentId)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateComment() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/comments")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", "Dwayne");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s", content)));
    }
}
