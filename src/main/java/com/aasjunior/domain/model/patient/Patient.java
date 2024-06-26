package com.aasjunior.domain.model.patient;

import com.aasjunior.domain.model.common.enums.Ethnicity;
import com.aasjunior.domain.model.common.enums.Gender;
import com.aasjunior.domain.model.guardian.Guardian;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private Gender gender;
    private Ethnicity ethnicity;
    private Boolean familyCases;
    private Boolean pregnancyComplications;
    private Boolean premature;
    private HashMap<String, Guardian> guardians;
    private LocalDateTime registerDate;

    public void addGuardian(Guardian guardian){
        this.guardians.put(guardian.getId(), guardian);
    }

    public static Patient fromRequest(PatientRequest request){
        return new Patient(
                null,
                request.firstName(),
                request.lastName(),
                request.birthDate(),
                request.gender(),
                request.ethnicity(),
                request.familyCases(),
                request.pregnancyComplication(),
                request.premature(),
                new HashMap<>(),
                LocalDateTime.now()
        );
    }
}