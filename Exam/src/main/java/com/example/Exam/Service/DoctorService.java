package com.example.Exam.Service;

import com.example.Exam.Dto.DoctorDto;
import com.example.Exam.model.Doctor;
import com.example.Exam.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public DoctorDto create(DoctorDto dto) {
        Doctor doctor = new Doctor();
       doctor.setName(dto.getName());
       doctor.setSurname(dto.getSurname());
       doctor.setContact(dto.getContact());
       doctor.setDirection(dto.getDirection());
       doctor.setStatus(true);
       doctor.setCreatedAt(LocalDateTime.now());
        doctorRepository.save(doctor);
        return doctor;

    }

    public DoctorDto get(Integer id) {
       Doctor entity = getEntity(id);
        DoctorDto doctorDto = new DoctorDto();
        convertEntityToDto(entity, doctorDto);
        return doctorDto;
    }

    private Doctor getEntity(Integer id) {
        Optional <Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("Doctor not find");
        }
        return optional.get();


    }

    private void convertEntityToDto(Doctor entity, DoctorDto doctorDto) {
        entity.setName(doctorDto.getName());
        entity.setExperience(doctorDto.getExperience());
        entity.setSurname(doctorDto.getSurname());
        entity.setContact(doctorDto.getContact());
        entity.setDirection(doctorDto.getDirection());
        entity.setId(doctorDto.getId());

    }

    private void  check(Integer id) {
        Optional <Doctor> optional = doctorRepository.findById(id);

    }

    public boolean update(Integer id, DoctorDto doctorDto) {
        Doctor update = getEntity(id);
        convertEntityToDto(update, doctorDto);
        doctorRepository.save(update);
        return true;

    }

    public boolean delete(Integer id) {
        Doctor delete = getEntity(id);
        doctorRepository.delete(delete);
        return true;
    }
}
