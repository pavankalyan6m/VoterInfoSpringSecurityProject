package com.security.project2.Controller;

import com.security.project2.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoterRegisterRequest {
    private String email;
    private String password;
    private Number voterAge;
    private String voterName;
    private Role role;
}