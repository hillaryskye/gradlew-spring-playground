package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by hillaryskye on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(QueryStringController.class)
public class QueryStringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndividualParamEndPoint() throws Exception {
        this.mockMvc.perform(get("/individual-example?filter=first"))
                .andExpect(status().isOk())
                .andExpect(content().string("Filter is: first"));
    }

    @Test
    public void testMapParamEndPoint() throws Exception {
        this.mockMvc.perform(get("/map-example?sort=hello&city=arvada"))
                .andExpect(status().isOk())
                .andExpect(content().string("{sort=hello, city=arvada}"));
    }

    @Test
    public void testObjectEndPoint() throws Exception {
        this.mockMvc.perform(get("/map-example?sort=[hello]&city=[arvada]"))
                .andExpect(status().isOk())
                .andExpect(content().string("{sort=[hello], city=[arvada]}"));
    }
}
