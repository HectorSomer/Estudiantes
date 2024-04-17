package org.hectorsomer.estudiantes.models;

import java.time.LocalDate;

public class Student {
    private String name;
    private LocalDate birthdate;
    private int matricula;
    private String carrera;
    public Student(String name, LocalDate birthdate, String carrera) {
        this.name = name;
        this.birthdate = birthdate;
        this.matricula = (int) (Math.random() * (6999) + 23000);
        this.carrera = carrera;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
