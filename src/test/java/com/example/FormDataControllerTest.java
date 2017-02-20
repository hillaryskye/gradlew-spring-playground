package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hillaryskye on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {
    @Autowired
    private MockMvc mvc;

    private int classId = 123;
    private String instructor = "Hillary";

    @Test
    public void testPostingFormdData() throws Exception {
        MockHttpServletRequestBuilder postRequest = post("/individual-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("classId", Integer.toString(classId))
                .param("instructor", instructor);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("instructor:%s classId:%d", instructor, classId)));
    }

    @Test
    public void testPostingFormDataMap() throws Exception {
        MockHttpServletRequestBuilder postRequest = post("/map")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("classId", Integer.toString(classId))
                .param("instructor", instructor);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{classId=%d, instructor=%s}", classId, instructor)));
    }

    @Test
    public void testPostingFormDataObj() throws Exception {
        MockHttpServletRequestBuilder postRequest = post("/object-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("classId", Integer.toString(classId))
                .param("instructor", instructor);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("instructor:%s classId:%d", instructor, classId)));


    }
}
