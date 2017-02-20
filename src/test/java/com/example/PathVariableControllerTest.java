package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hillaryskye on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)

public class PathVariableControllerTest {

    @Autowired
    private MockMvc mvc;

    private String animal = "Cat";
    private String sound = "meow";

    @Test
    public void testIndividualPathVarEndpoint() throws Exception {
        this.mvc.perform(get(String.format("/animals/%s/%s", animal, sound)))
                .andExpect(status().isOk())
                .andExpect(content().string("animal:" + animal + " sound:" + sound));
    }

    @Test
    public void testMapPathVarEndpoint() throws Exception {
        this.mvc.perform(get(String.format("/animals/%s/map/%s", animal, sound)))
                .andExpect(status().isOk())
                .andExpect(content().string("{animal=" + animal + ", sound=" + sound + "}"));
    }

    @Test
    public void testObjectPathVarEndPoint() throws Exception {
        this.mvc.perform(get(String.format("/animals/%s/object/%s", animal, sound)))
                .andExpect(status().isOk())
                .andExpect(content().string("animal:" + animal + " sound:" + sound));
    }
}
