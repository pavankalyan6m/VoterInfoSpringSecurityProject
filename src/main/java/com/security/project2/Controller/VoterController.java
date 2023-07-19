package com.security.project2.Controller;

import com.security.project2.Entity.Voter;
import com.security.project2.Service.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/p2")
@RequiredArgsConstructor
public class VoterController {

    private final VoterService service;
    private final VoterAuthenticationService voterAuthenticationService;
    @GetMapping("/voterList/All")
    public List<Voter> getVoterList()
    {
        return service.getVoterDetails();
    }

    @GetMapping("/voterList/AllEligible")
    public List<Voter> getAllEligibleVoters()
    {
        return service.getAllEligibleVoterDetails();
    }

    @GetMapping("/voterList/{id}")
    public Optional<Voter> getVoterListById(@PathVariable int id)
    {
        return service.getVoterDetailsById(id);
    }

    @PostMapping("/voterList/insert")
    public ResponseEntity<VoterAuthenticationResponse> voterListInsert(@RequestBody VoterRegisterRequest request)
    {
        return ResponseEntity.ok(voterAuthenticationService.voterDetailsInsert(request));
    }


    @PostMapping("/voterList/authenticate")
    public ResponseEntity<VoterAuthenticationResponse> voterListAuthenticate(@RequestBody VoterAuthenticationRequest request) {
        return ResponseEntity.ok(voterAuthenticationService.voterDetailsAuthenticate(request));
    }


}
