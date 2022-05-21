package com.example.Exam.Service;

import com.example.Exam.Dto.VisitDto;
import com.example.Exam.exception.BadRequest;
import com.example.Exam.model.Visit;
import com.example.Exam.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    public VisitDto create(VisitDto visitDto) {
    Visit visit = new Visit();
        convertDtoToEntity(visitDto,visit);
        visit.setCreatedAt(LocalDateTime.now());
        visit.setStatus(true);
        visitRepository.save(visit);
    return visitDto;

    }

    private void convertDtoToEntity(VisitDto visitDto, Visit visit) {
        visit.setDoctor(visitDto.getDoctor());
        visit.setPatient(visitDto.getPatient());
        visit.setDiognosis(visitDto.getDiognosis());
        visit.setPatient_id(visit.getPatient_id());
        visit.setDoctor_id(visitDto.getDoctor_id());
    }

    public VisitDto get(Integer id) {
      Visit get = getEntity(id);
      Visit entity = new Visit();
      VisitDto visitDto = new VisitDto();
     convertEntityToDto(entity,visitDto);
     return visitDto;
    }

    private void convertEntityToDto(Visit entity, VisitDto visitDto) {
        visitDto.setDiognosis(entity.getDiognosis());
        visitDto.setDoctor(entity.getDoctor());
        visitDto.setPatient(entity.getPatient());
        visitDto.setPatient_id(entity.getPatient_id());
        visitDto.setDoctor_id(entity.getDoctor_id());
        visitDto.setId(entity.getId());

    }

    private Visit getEntity(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Visit not found");

        }
       return optional.get();
    }

    public boolean update(Integer id, VisitDto visitDto) {
        Visit update = getEntity(id);
        Visit visit = new Visit();
        convertDtoToEntity(visitDto,update);
        return true;

    }

    public boolean delete(Integer id) {
        Visit delete = getEntity(id);
        visitRepository.delete(delete);
        return true;

    }
}
