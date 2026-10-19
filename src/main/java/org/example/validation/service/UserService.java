package org.example.validation.service;

import lombok.AllArgsConstructor;
import org.example.validation.dto.UserDTO;
import org.example.validation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final IdService idService;

    public User saveUser(UserDTO userDTO) {
        User newUser = User.builder()
                .id(idService.nextId())
                .username(userDTO.username())
                .age(userDTO.age())
                .email(userDTO.email())
                .password(userDTO.password())
                .build();
        return userRepo.save(newUser);
    }

    public List<User> findUsersByAge(Integer age){
        return userRepo.findAllByAge(age);
    }
}
