package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/map-example")
//    public String getMapParams(@RequestParam Map querystring) {
//        return querystring.toString();
//    }

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

    @GetMapping("/individual-example/{q}/{from}") // matches / individual-example/foo/bar
    public String getIndividualParams(@PathVariable String from, @PathVariable("q") String query) {
        return String.format("q:%s from:%s", query, from );
    }

    @GetMapping("/tasks/{taskId}/comments/{commentId}")
    public String getCommentsForTask(@PathVariable int taskId, @PathVariable int commentId) {
        return String.format("taskId is %d; commentId is %d", taskId, commentId);
    }

    // Access to path variables as a Map in an object
    @GetMapping("/test/tasks/{taskId}/comments/{commentId}")
    public String getCommentsForTask(@PathVariable Map pathVariables) {
        return pathVariables.toString(); // {taskId=46, commentId=35}
    }

    @PostMapping("/string-examaple")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

    @PostMapping(path = "/people")
    public String showFormData(@RequestBody Map<String, String> body) {
        return body.toString();  // {first_name=Dwayne, last_name=Johnson}
    }



//    public class TaskIds {
//        private int taskId;
//        private int commentId;
//
//
//        public int getTaskId() {
//            return taskId;
//        }
//
//        public void setTaskId(int taskId) {
//            this.taskId = taskId;
//        }
//
//        public int getCommentId() {
//            return commentId;
//        }
//
//        public void setCommentId(int commentId) {
//            this.commentId = commentId;
//        }
//
//        @GetMapping("/test/tasks/{taskId}/comments/{commentId}")
//        public String getCommentsForTask(TaskIds ids) {
//            return String.format("taskId is %d; commentId is %s", ids.getTaskId(), ids.getCommentId());
//        }
//    }

//    MockHttpServletRequestBuilder request1 = post("/comments")
//            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//            .param("content", "Firsties!")
//            .param("author", "Dwayne");
}