package com.aasjunior.domain.model.guardian;

import com.aasjunior.domain.model.patient_guardian.PatientGuardian;
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
public class Guardian {
        @Id
        private String id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        private HashMap<String, PatientGuardian> patients;

        public void addPatient(PatientGuardian patientGuardian){
                this.patients.put(patientGuardian.patientId(), patientGuardian);
        }

        public static Guardian fromRequest(GuardianRequest request){
                return new Guardian(
                        null,
                        request.firstName(),
                        request.lastName(),
                        request.phone(),
                        request.email(),
                        new HashMap<>()
                );
        }
}