package com.internship.introproject.controller;

import com.internship.introproject.dto.UserDTO;
import com.internship.introproject.repository.UserRepository;
import com.internship.introproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
