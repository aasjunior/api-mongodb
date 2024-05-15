package com.aasjunior.domain.model.patient;

import com.aasjunior.domain.model.common.enums.Ethnicity;
import com.aasjunior.domain.model.common.enums.Gender;

public record PatientRequest(
        String firstName,
        String lastName,
        String birthDate,
        Gender gender,
        Ethnicity ethnicity,
        Boolean familyCases,
        Boolean pregnancyComplication,
        Boolean premature
) {
}
