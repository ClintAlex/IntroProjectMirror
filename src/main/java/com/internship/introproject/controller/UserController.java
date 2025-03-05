package com.internship.introproject.controller;

import com.internship.introproject.dto.UserDTO;
import com.internship.introproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("saveUsers")
    public List<UserDTO> saveUsers(@RequestBody List<UserDTO> userDTOs) {
        List<UserDTO> savedUsers = new ArrayList<>();
        for (UserDTO userDTO : userDTOs) {
            savedUsers.add(userService.saveUser(userDTO));
        }
        return savedUsers;
    }
}