package com.f1soft.turnovers.controller;

import com.f1soft.turnovers.entity.Link;
import com.f1soft.turnovers.entity.Member;
import com.f1soft.turnovers.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    LinkRepository linkRepository;

    @GetMapping("/api/links")
    public List<Link> getLinks() {

        List<Link> link = linkRepository.findByUserId("socra810@gmail.com");
        System.out.println(link);
        return link;
    }
}
