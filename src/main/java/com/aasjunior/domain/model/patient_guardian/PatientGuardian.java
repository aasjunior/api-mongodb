package com.aasjunior.domain.model.patient_guardian;

import com.aasjunior.domain.model.common.enums.Kinship;

public record PatientGuardian(
        String patientId,
        String guardianId,
        Kinship kinship
){}
