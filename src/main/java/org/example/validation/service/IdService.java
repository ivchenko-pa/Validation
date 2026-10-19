package org.example.validation.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class IdService {

    public String nextId(){
        return  UUID.randomUUID().toString();
    }
}