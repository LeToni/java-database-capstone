package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "doctor")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(nullable = false, length = 50)
    private String specialty;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 6)
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @Pattern(regexp = "^(?=(?:.*\\d){10}$)[0-9\\s-]+$")
    @Column(nullable = false, length = 20)
    private String phone;

    @ElementCollection
    @CollectionTable(name = "doctor_available_times", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "available_times")
    private List<String> availableTimes = new ArrayList<>();

    public Doctor() {}

    public Doctor(String name, String specialty, String email, String password, String phone) {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.availableTimes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes != null ? availableTimes : new ArrayList<>();
    }

    public void addAvailableTime(String timeSlot) {
        if (this.availableTimes == null) {
            this.availableTimes = new ArrayList<>();
        }
        this.availableTimes.add(timeSlot);
    }

    public void removeAvailableTime(String timeSlot) {
        if (this.availableTimes != null) {
            this.availableTimes.remove(timeSlot);
        }
    }
}

