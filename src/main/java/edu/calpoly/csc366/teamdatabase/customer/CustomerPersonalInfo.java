package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class CustomerPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerInfoId;
    private String name;
    private String phone;
    private String email;
    private String address;
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
}

