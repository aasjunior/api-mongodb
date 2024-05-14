package com.aasjunior.domain.model.guardian;

import com.aasjunior.domain.model.patient_guardian.PatientGuargianDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "guardians")
public class GuardianDTO{
        @Id
        private String id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        private HashMap<String, PatientGuargianDTO> patients;

        public void addPatient(PatientGuargianDTO patientGuargianDTO){
                this.patients.put(patientGuargianDTO.patientId(), patientGuargianDTO);
        }
}
