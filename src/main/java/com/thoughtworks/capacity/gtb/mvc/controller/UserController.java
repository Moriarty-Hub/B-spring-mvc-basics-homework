package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.entity.UserDTO;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
    public UserDTO login(@RequestParam
                             @NotEmpty(message = "The username cannot be empty")
                             @Size(min = 3, message = "The length of username is too short")
                             @Size(max = 10, message = "The length of username is too long")
                             @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "The username cannot contain any other character than number, alphabet and underline")
                                     String username,
                         @RequestParam
                         @NotEmpty(message = "The password cannot be empty")
                         @Size(min = 5, message = "The length of password is too short")
                         @Size(max = 12, message = "The length of password is too long")
                                 String password) {
        return userService.login(username, password);
    }
}
