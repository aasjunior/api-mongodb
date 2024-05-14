package com.aasjunior.domain.model.patient_guardian;

import com.aasjunior.domain.model.common.enums.Kinship;

public record PatientGuargianDTO(
        String patientId,
        String quargianId,
        Kinship kinship
){}
