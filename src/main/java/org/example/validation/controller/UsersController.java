package org.example.validation.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.validation.dto.UserDTO;
import org.example.validation.model.User;
import org.example.validation.service.UserService;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @ExceptionHandler
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return  e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
    }

}
