package com.aasjunior.domain.controller;

import com.aasjunior.domain.model.guardian.Guardian;
import com.aasjunior.domain.service.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guardians")
public class GuardianController {
    private final GuardianService guardianService;

    @GetMapping
    public ResponseEntity<List<Guardian>> getAllGuardians(){
        List<Guardian> guardians = guardianService.getAllGuardians();
        return new ResponseEntity<>(guardians, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable String id){
        Optional<Guardian> guardian = guardianService.getGuardianById(id);
        return guardian
                .map(value ->
                    new ResponseEntity<>(value, HttpStatus.OK)
                )
                .orElseGet(() ->
                    new ResponseEntity<>(HttpStatus.NOT_FOUND)
                );
    }

    @PostMapping
    public ResponseEntity<Guardian> createGuardian(@RequestBody Guardian guardian){
        return guardianService.createGuardian(guardian);
    }
}
