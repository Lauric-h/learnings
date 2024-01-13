package com.springmsa.rebels.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Rebels {
        @Id
        @GeneratedValue
        private int id;
        private String lastName;
        private String firstName;
        @JsonFormat(pattern="yyyy-MM-dd")
        private LocalDate birthDate;
        private int licenseNumber;
        @JsonFormat(pattern="yyyy-MM-dd")
        private LocalDate licenseDate;

        public Rebels (int id, String lastName, String firstName, LocalDate birthDate, int licenseNumber, LocalDate licenseDate){

            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.birthDate = birthDate;
            this.licenseNumber = licenseNumber;
            this.licenseDate =  licenseDate;

        }

        public Rebels (){

        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(LocalDate licenseDate) {
        this.licenseDate = licenseDate;
    }
}
