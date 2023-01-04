package com.f1soft.turnovers.repository;

import com.f1soft.turnovers.entity.Link;
import com.f1soft.turnovers.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByEmail(String email);
}
