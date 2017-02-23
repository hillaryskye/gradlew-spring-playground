package com.example;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by hillaryskye on 2/22/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class CookieControllerTest {

    @Autowired
    private MockMvc mvc;

//    @Test
//    public void testCookies() throws Exception {
//        this.mvc.perform(get("/cookie").cookie(new Cookie("foo", "bar")))
//                .andExpect(status().isOk())
//                .andExpect(content().string("bar"));
//    }
//
//    @Test
//    public void testHeaders() throws Exception {
//        this.mvc.perform(get("/header").header("Host", "example.com"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("example.com"));
//    }
}
