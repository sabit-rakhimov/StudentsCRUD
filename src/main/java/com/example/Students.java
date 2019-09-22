package com.example;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by S.Rakhimov
 */
public class Students {
    private Long idstudents;
    private String Name;
    private String Surname;
    private String facultet;
    private Date dayOfBirth;

    public Long getIdstudents() {
        return idstudents;
    }

    public void setIdstudents(Long idstudents) {
        this.idstudents = idstudents;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
