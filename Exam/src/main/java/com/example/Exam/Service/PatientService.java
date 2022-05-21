package com.example.Exam.Service;

import com.example.Exam.Dto.PatientDto;
import com.example.Exam.exception.BadRequest;
import com.example.Exam.model.Patient;
import com.example.Exam.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public PatientDto create(PatientDto patientDto) {
        Patient patient = new Patient();
        convertDtoToEntity(patientDto,patient);

        patient.setStatus(true);
        patient.setCreatedAt(LocalDateTime.now());
        patientRepository.save(patient);
        return patient;
    }

    private void convertDtoToEntity(PatientDto patientDto, Patient patient) {
        patient.setName(patientDto.getName());
        patient.setContact(patientDto.getContact());
        patient.setBirthday(patientDto.getBirthday());
        patient.setSurname(patient.getSurname());
        patient.setDirection(patientDto.getDirection());
        patientDto.setId(patient.getId());
        patient.setExperience(patientDto.getExperience());
    }

    public PatientDto get(Integer id) {
        Patient patient = getEntity(id);
        PatientDto get = new PatientDto();
        convertEntityToDto(patient, get);
        return get;

    }

    private Patient getEntity(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        return optional.get();

    }

    private void convertEntityToDto(Patient patient, PatientDto get) {
        get.setName(patient.getName());
        get.setSurname(patient.getSurname());
        get.setContact(patient.getContact());
        get.setBirthday(patient.getBirthday());
        get.setDirection(patient.getDirection());
        get.setStatus(true);
        get.setId(patient.getId());
        get.setCreatedAt(patient.getCreatedAt());
        get.setExperience(patient.getExperience());

    }



    public boolean update(Integer id, PatientDto patient) {
        getEntity(id);
        Patient update = new Patient();
        convertEntityToDto(update,patient);
        return true;

    }

    public boolean delete(Integer id) {
       Patient patient = getEntity(id);

        patientRepository.delete(patient);
        return true;

    }
}
