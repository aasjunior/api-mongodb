package com.aasjunior.domain.repositoy;

import com.aasjunior.domain.model.patient.PatientDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<PatientDTO, String> {

}
