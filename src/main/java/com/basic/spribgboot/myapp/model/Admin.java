package com.basic.spribgboot.myapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admin")
public class Admin {

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Id
    @Column(name = "email", nullable = false, length = 100)
    private String email; // Primary Key

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public Admin() {
    }

    public Admin(String fullName, String email, String password, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
