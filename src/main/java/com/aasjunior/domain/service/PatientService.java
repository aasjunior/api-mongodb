package com.aasjunior.domain.service;

import com.aasjunior.domain.model.guardian.Guardian;
import com.aasjunior.domain.model.patient.Patient;
import com.aasjunior.domain.model.patient.PatientRequest;
import com.aasjunior.domain.model.patient_guardian.PatientGuardian;
import com.aasjunior.domain.model.patient_guardian.PatientGuardianRequest;
import com.aasjunior.domain.repositoy.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final GuardianService guardianService;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id){
        return patientRepository.findById(id);
    }

    public ResponseEntity<Patient> createPatient(PatientRequest patientRequest){
        try{
            Patient savedPatient = patientRepository.save(Patient.fromRequest(patientRequest));
            return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Patient> addGuardianToPatient(String patientId, Guardian guardian){
        Optional<Patient> patientData = patientRepository.findById(patientId);

        if(patientData.isPresent()){
            Patient patient = patientData.get();
            patient.addGuardian(guardian);
            return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Patient> createPatientWithGuardian(PatientGuardianRequest request){
        try{
            Patient patient = patientRepository.save(
                    Patient.fromRequest(request.patientRequest())
            );

            ResponseEntity<Guardian> response = guardianService.createGuardian(
                    Guardian.fromRequest(request.guardianRequest())
            );

            if(response.getStatusCode() == HttpStatus.CREATED){
                Guardian guardian = response.getBody();

                PatientGuardian patientGuardian = new PatientGuardian(
                        patient.getId(),
                        guardian.getId(),
                        request.kinship()
                );
                guardian.addPatient(patientGuardian);
                addGuardianToPatient(patient.getId(), guardian);
                guardianService.addPatientToGuardian(patientGuardian);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
            if(optionalPatient.isPresent()){
                return new ResponseEntity<>(optionalPatient.get(), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
