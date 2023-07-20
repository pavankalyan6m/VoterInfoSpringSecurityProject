package com.security.project2.Welcome;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api/p2/welcome-controller")
public class WelcomeController{
    @GetMapping
    public ResponseEntity<String> sayingHello()
    {
        return ResponseEntity.ok("Hello, Welcome!... this is a secured Endpoint ");
    }

}
