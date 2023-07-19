package com.security.project2.Service;

import com.security.project2.Entity.Voter;
import com.security.project2.Repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
@RequiredArgsConstructor
public class VoterService {

    private final VoterRepository voterRepository;

    public List<Voter> getVoterDetails() {
        return voterRepository.findAll();
    }

    public List<Voter> getAllEligibleVoterDetails() {
        List<Voter> voters = voterRepository.findAll();
        List<Voter> eligibleVoters = new ArrayList<>();

        for (Voter voter : voters) {
            Integer age = voter.getVoterAge();
            if (age!=null && age >= 18) {
                eligibleVoters.add(voter);
            }
        }
        return eligibleVoters;
    }


    public Optional<Voter> getVoterDetailsById(int id) {
        return voterRepository.findById(id);
    }
}

