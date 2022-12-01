package com.f1soft.turnovers.repository;

import com.f1soft.turnovers.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
