package com.f1soft.turnovers.controller;

import com.f1soft.turnovers.dto.TestDto;
import com.f1soft.turnovers.entity.Item;
import com.f1soft.turnovers.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/api/items")
    public List<Item> getItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @PostMapping("/api/items")
    public String test(@RequestBody TestDto dto) {
//        System.out.println("111");
        return dto.toString();
    }
}
