package com.security.project2.Controller;

import com.security.project2.Configuration.VoterJwtService;
import com.security.project2.Repository.VoterRepository;
import com.security.project2.Entity.Role;
import com.security.project2.Entity.Voter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterAuthenticationService {
    private final VoterRepository voterRepository;
    private final PasswordEncoder passwordEncoder;
    private final VoterJwtService voterJwtservice;
    private final AuthenticationManager authenticationManager;

    public VoterAuthenticationResponse voterDetailsInsert(VoterRegisterRequest request) {
        var user = Voter.builder()
                .voterName(request.getVoterName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .voterAge((Integer) request.getVoterAge())
                .role(Role.User)
                .build();
        var savedUser = voterRepository.save(user);
        var jwtToken = voterJwtservice.generateToken(user);
        //var refreshToken = voterJwtService.generateRefreshToken(user);
        //saveUserToken(savedUser, jwtToken);
        return VoterAuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public VoterAuthenticationResponse voterDetailsAuthenticate(VoterAuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = voterRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = voterJwtservice.generateToken(user);

        return VoterAuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}