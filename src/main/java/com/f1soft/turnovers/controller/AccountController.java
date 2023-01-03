package com.f1soft.turnovers.controller;

import com.f1soft.turnovers.entity.Member;
import com.f1soft.turnovers.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/api/account/login")
    public int login(@RequestBody Map<String, String> userInfo) {
        Member member = memberRepository.findByEmail(userInfo.get("email"));

        if (member != null) {
            return member.getId();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
