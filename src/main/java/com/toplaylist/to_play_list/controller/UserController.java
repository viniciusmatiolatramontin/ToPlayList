package com.toplaylist.to_play_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toplaylist.to_play_list.model.UserAuth;
import com.toplaylist.to_play_list.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @ResponseBody
    @PostMapping("/register")
    public UserAuth addUser(@RequestBody UserAuth user) {
        return service.addUser(user);
    }
}
