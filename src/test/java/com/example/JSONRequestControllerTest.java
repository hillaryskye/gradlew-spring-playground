package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONRequestController.class)

public class JSONRequestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testObjectParamsSentAsString() throws Exception {

        MockHttpServletRequestBuilder request = post("/json/string-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"make\":\"Nissan\",\"model\":\"Altima\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"make\":\"Nissan\",\"model\":\"Altima\"}"));

    }

    @Test
    public void testCreateJSONObjectSerializedWithGSON() throws Exception {

        JSONRequestController.Car[] per1_cars = new JSONRequestController.Car[2];
        per1_cars[0] = new JSONRequestController.Car("Toyota", "Tundra");
        per1_cars[1] = new JSONRequestController.Car("Honda", "Accord");
        JSONRequestController.Person person = new JSONRequestController.Person("Joey", per1_cars);
        // Create the gson builder
        Gson gson = new GsonBuilder().create();

        MockHttpServletRequestBuilder request = post("/json/object-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(person));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"Joey\",\"cars\":[{\"make\":\"Toyota\",\"model\":\"Tundra\"},{\"make\":\"Honda\",\"model\":\"Accord\"}]}"));

    }

    @Test
    public void testCreateJSONObjectFromFileFixture() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/json/object-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(json));

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}


