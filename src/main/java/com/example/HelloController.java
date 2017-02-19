package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/Hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/individual")
    public String getIndividualParams(@RequestParam String filter) {
        return String.format("Filter is : %s", filter);
    }

    @GetMapping("/people")
    public String getPeople(
            @RequestParam("sort-by") String sortBy,
            @RequestParam(value = "sort-dir") String sortDirection) {
        return String.format("sortBy is %s and sortDirection is %s", sortBy, sortDirection);
    }

    @GetMapping("/map-example")
    public String getMapParams(@RequestParam Map querystring) {
        return querystring.toString();
    }

    @GetMapping("/hillary")
    public String getMapParams(@RequestParam MultiValueMap<String, String> querystring) {
        return querystring.toString();
    }

//    public class TaskInfo {
//        public String getSortBy() {
//            return sortBy;
//        }
//
//        public void setSortBy(String sortBy) {
//            this.sortBy = sortBy;
//        }
//
//        public String getOwner() {
//            return Owner;
//        }
//
//        public void setOwner(String owner) {
//            Owner = owner;
//        }
//
//        private String sortBy;
//        private String Owner;
//
////        @GetMapping("/tasks")
////        public String getTasks(TaskInfo taskInfo) {
////            return String.format("sort-by is %s; owner is %s", taskInfo.getSortBy());
////        }
//
//        @GetMapping("/tasks")
//        public String getMapParams(@RequestParam Map querystring) {
//            return querystring.toString();
//        }

//    }




}