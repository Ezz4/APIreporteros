package com.dailybugle.daily_bugle1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Reportero {

    @Id
    @SequenceGenerator(
            name = "reportero_sequence",
            sequenceName = "reportero_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reportero_sequence"
    )
    private Long id;
    private String nombre;
    @Transient
    private int edad;
    private LocalDate nacimiento;
    private String email;
    private String ciudad;

    public Reportero() {
    }

    public Reportero(Long id, String nombre, LocalDate nacimiento, String email, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.email = email;
        this.ciudad = ciudad;
    }

    public Reportero(String nombre, LocalDate nacimiento, String email, String ciudad) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.email = email;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return Period.between(this.nacimiento, LocalDate.now()).getYears();
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Reportero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacimiento=" + nacimiento +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
