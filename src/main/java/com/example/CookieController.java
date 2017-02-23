package com.example;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hillaryskye on 2/22/17.
 */

@RestController
public class CookieController {
    @GetMapping("/cookie")
    public String getCookie(@CookieValue(name = "foo", defaultValue = "hello") String cookie) {
        return cookie;
    }

    @RequestMapping("/response-cookie")
    public HttpServletResponse getCookie(HttpServletResponse response) {
        response.addCookie(new Cookie("foo", "bar"));
        return response;
    }
}
