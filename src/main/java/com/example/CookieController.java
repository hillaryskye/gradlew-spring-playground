package com.example;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/header")
    public HttpServletResponse getHeader(@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent, HttpServletResponse response) {
        return response;
    }
}
