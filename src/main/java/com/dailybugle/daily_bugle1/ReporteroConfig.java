package com.dailybugle.daily_bugle1;


import com.dailybugle.daily_bugle1.model.Reportero;
import com.dailybugle.daily_bugle1.repository.ReporteroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ReporteroConfig {

    @Bean
    CommandLineRunner commandLineRunner(ReporteroRepository repository){
        return args -> {
           Reportero emma = new Reportero(
                    "Emma",
                    LocalDate.of(1992, Month.DECEMBER, 24),
                    "Emma@gmail.com",
                    "Guadalajara"
            );
           Reportero scar = new Reportero(
                    "Scar",
                    LocalDate.of(1992, Month.DECEMBER, 24),
                    "scar@gmail.com",
                    "Mazatlan"
            );

           repository.saveAll(
                   List.of(emma, scar)
           );
        };
    }
}
