package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserDTO;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    public UserDTO login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }
}
