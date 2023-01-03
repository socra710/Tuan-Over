package com.f1soft.turnovers.repository;

import com.f1soft.turnovers.entity.Person;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);
}
