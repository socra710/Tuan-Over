package com.f1soft.turnovers.controller;

import com.f1soft.turnovers.entity.Person;
import com.f1soft.turnovers.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/api/account/login")
    public int login(@RequestBody Map<String, String> userInfo) {
        Person person = personRepository.findByEmail(userInfo.get("email"));

        if (person != null) {
            return person.getId();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
