package com.aasjunior.domain.model.guardian;

public record GuardianRequest(
        String firstName,
        String lastName,
        String phone,
        String email
){
}
