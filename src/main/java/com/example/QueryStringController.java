package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hillaryskye on 2/19/17.
 */

@RestController

public class QueryStringController {

    @GetMapping(value = "/individual-example")
    public String getIndividualParams(@RequestParam String filter) {// http://localhost:8080/individual-example/?filter=first
        return String.format("Filter is: %s", filter); // Filter is: first
    }

    @GetMapping("/map-example")
    public String getMapParams(@RequestParam Map querystring) {// http://localhost:8080/map-example/?sort=hello&city=arvada
        return querystring.toString(); // {sort=hello, city=arvada}
    }

    @GetMapping("/custom-object")
    public String getMapParams(@RequestParam MultiValueMap<String, String> querystring) { // http://localhost:8080/custom-object/?sort=hello&city=arvada
        return querystring.toString(); // {sort=[hello], city=[arvada]}
    }

//    @GetMapping("/custom-object")
//    public String getTasks(CustomObject co) {
//        return String.format("sort-by is %s; city is %s", co.getHouse(), co.getCity());
//    }

//    public static class CustomObject {
//        public String getHouse() {
//            return house;
//        }
//
//        public void setHouse(String house) {
//            this.house = house;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        private String house;
//        private String city;
//    }
}
