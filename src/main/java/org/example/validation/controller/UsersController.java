package org.example.validation.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.example.validation.dto.UserDTO;
import org.example.validation.model.User;
import org.example.validation.service.UserService;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Validated
public class UsersController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{age}")
    public List<User> findUsersByAge(@PathVariable
                              @Pattern(regexp = "[0-9]{2}", message = "Wrong format for Age")
                              @Min(value = 16, message = ("Age should be min 16"))
                              Integer age) {
        return userService.findUsersByAge( age);
    }

    @ExceptionHandler
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
    }

}
