package com.f1soft.turnovers.repository;

import com.f1soft.turnovers.entity.Link;
import com.f1soft.turnovers.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    List<Link> findByUserId(int userId);
}
