package com.lxyw.controller;

import com.lxyw.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {

    @RequestMapping(value="getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("test");
        return user;
    }
}
