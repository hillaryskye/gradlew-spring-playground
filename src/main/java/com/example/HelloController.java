package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/tasks")
    public String addWorld() {
        return "add from Spring";
    }

    @DeleteMapping("/tasks")
    public String deleteWorld() {
        return "Deleted from Spring";
    }

    @PatchMapping("/hillary")
    public String hillaryWorld() {
        return "Patch from Spring";
    }
}