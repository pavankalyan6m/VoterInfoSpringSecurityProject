package com.security.project2.Repository;

import com.security.project2.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
     Optional<Voter> findByEmail(String email);
}
