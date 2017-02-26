
/**
 * Created by hillaryskye on 2/26/17.
 */

package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONResponseController.class)
public class JSONResponseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testObject() throws Exception {
        this.mvc.perform(
                get("/json/new-object")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testArray() throws Exception {
        this.mvc.perform(
                get("/json/array")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));
    }

}