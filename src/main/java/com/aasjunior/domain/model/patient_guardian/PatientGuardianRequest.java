package com.aasjunior.domain.model.patient_guardian;

import com.aasjunior.domain.model.common.enums.Kinship;
import com.aasjunior.domain.model.guardian.GuardianRequest;
import com.aasjunior.domain.model.patient.PatientRequest;

public record PatientGuardianRequest(
        PatientRequest patientRequest,
        GuardianRequest guardianRequest,
        Kinship kinship
) {
}
