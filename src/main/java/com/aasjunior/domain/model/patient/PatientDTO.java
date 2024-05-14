package com.aasjunior.domain.model.patient;

import com.aasjunior.domain.model.common.enums.Ethnicity;
import com.aasjunior.domain.model.common.enums.Gender;
import com.aasjunior.domain.model.guardian.GuardianDTO;
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
public class PatientDTO {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String birthDate;
    private Ethnicity ethnicity;
    private Boolean familyCases;
    private Boolean pregnancyComplications;
    private Boolean premature;
    private HashMap<String, GuardianDTO> guardians;
    private LocalDateTime registerDate;

    public void addGuardian(GuardianDTO guardianDTO){
        this.guardians.put(guardianDTO.getId(), guardianDTO);
    }
}