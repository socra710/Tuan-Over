package com.f1soft.turnovers.controller;

import com.f1soft.turnovers.entity.Link;
import com.f1soft.turnovers.entity.Member;
import com.f1soft.turnovers.entity.Person;
import com.f1soft.turnovers.repository.LinkRepository;
import com.f1soft.turnovers.repository.PersonRepository;
import com.f1soft.turnovers.service.JwtService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    LinkRepository linkRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    JwtService jwtService;

    @GetMapping("/api/links")
    public ResponseEntity getLinks(@CookieValue(value = "token", required = false) String token) {

        Claims claims = jwtService.getClaims(token);

        if (claims != null) {
            int id = Integer.parseInt(claims.get("id").toString());

            List<Link> link = linkRepository.findByUserId(id);
            return new ResponseEntity<>(link, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
