package com.dailybugle.daily_bugle1.service;


import com.dailybugle.daily_bugle1.model.Reportero;
import com.dailybugle.daily_bugle1.repository.ReporteroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReporteroService {


    private final ReporteroRepository reporteroRepository;

    @Autowired
    public ReporteroService(ReporteroRepository reporteroRepository) {
        this.reporteroRepository = reporteroRepository;
    }

    public List<Reportero> getReportero() {
        return reporteroRepository.findAll();
    }

    public void addNewReportero(Reportero reportero){
        Optional<Reportero> reporteroOptional= reporteroRepository
                .findReporteroByEmail(reportero.getEmail());
        if(reporteroOptional.isPresent()){
            throw  new IllegalStateException("email taken");
        }
        reporteroRepository.save(reportero);
    }

    public void deleteReportero(Long reporteroId) {
        reporteroRepository.findById(reporteroId);
        boolean exist = reporteroRepository.existsById(reporteroId);
        if(!exist){
            throw new IllegalStateException(
                    "El reportero con el ID" + reporteroId + "no existe"
            );
        }
        reporteroRepository.deleteById(reporteroId);
    }
    @Transactional
    public void updateReportero(Long reporteroId, String nombre,  String email, String ciudad) {
       Reportero reportero =  reporteroRepository.findById(reporteroId).orElseThrow(() ->new IllegalStateException(
                "El reportero con el ID" + reporteroId + " no existe"
        ));

        if(nombre != null && nombre.length() > 0 && !Objects.equals(reportero.getNombre(), nombre)){
            reportero.setNombre(nombre);
        }

        if(email != null && email.length() > 0 && !Objects.equals(reportero.getEmail(), email)){
            Optional<Reportero> reporteroOptional = reporteroRepository.findReporteroByEmail(email);
            if(reporteroOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            reportero.setEmail(email);
        }

        if(ciudad != null && ciudad.length() > 0 && !Objects.equals(reportero.getCiudad(), ciudad)){
            reportero.setCiudad(ciudad);
        }
    }
}
