package com.example.practicaltask.controller;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable long id) throws Exception{
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
