package com.aasjunior.domain.repositoy;

import com.aasjunior.domain.model.patient.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
