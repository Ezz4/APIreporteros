package com.dailybugle.daily_bugle1.controller;

import com.dailybugle.daily_bugle1.model.Reportero;
import com.dailybugle.daily_bugle1.service.ReporteroService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reportero")

public class ReporteroController {

    private final ReporteroService reporteroService;


    @Autowired
    public ReporteroController(ReporteroService reporteroService){
        this.reporteroService =  reporteroService;
    }

    @GetMapping
    public List<Reportero> getReportero() {
        return reporteroService.getReportero();
    }


    @PostMapping
    public void registerNewReportero(@RequestBody Reportero reportero){
        reporteroService.addNewReportero(reportero);
    }

    @DeleteMapping(path = "{reporteroId}")
    public void deleteReportero(@PathVariable("reporteroId") Long reporteroId){
        reporteroService.deleteReportero(reporteroId);
    }

    @PutMapping(path="{reporteroId}")
    public void updateReportero(
            @PathVariable("reporteroId") Long reporteroId,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String ciudad
            ){
        reporteroService.updateReportero(reporteroId, nombre, email, ciudad);
    }

}
