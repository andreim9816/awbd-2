package com.example.consultservice;

import com.example.domain.Consult;
import com.example.domain.dto.input.ReqConsultDto;
import com.example.domain.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultService {

    private final ConsultRepository consultRepository;
    private final ConsultMapper consultMapper;

    @Autowired
    public ConsultService(ConsultRepository consultRepository, ConsultMapper consultMapper) {
        this.consultRepository = consultRepository;
        this.consultMapper = consultMapper;
    }

    public List<Consult> getAllConsults() {
        return consultRepository.findAll();
    }

    public Consult getConsultById(Long id) {
        return consultRepository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.builder()
                        .entityId(id)
                        .entityType("Consult")
                        .build()
                );
    }

    public Boolean checkIfConsultExists(Long id) {
        return consultRepository.findById(id).isPresent();
    }

    public List<Consult> getAllConsultsForDoctorAndPatient(Long doctorId, Long patientId) {
        return consultRepository.getConsultsByDoctorIdAndPatientId(doctorId, patientId);
    }

    public Consult updateConsult(Consult consult, Consult consultToBeUpdated) {
        Consult updatedConsult = consultMapper.update(consult, consultToBeUpdated);

        return saveConsult(updatedConsult);
    }

    public Consult saveConsult(Consult consult) {
        consult.setDate(new Date());
        return consultRepository.save(consult);
    }

    public void deleteConsultById(Long id) {
        consultRepository.deleteById(id);
    }
}
