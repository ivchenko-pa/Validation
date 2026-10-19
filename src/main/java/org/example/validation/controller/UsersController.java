package org.example.validation.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.validation.dto.UserDTO;
import org.example.validation.model.User;
import org.example.validation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

}
