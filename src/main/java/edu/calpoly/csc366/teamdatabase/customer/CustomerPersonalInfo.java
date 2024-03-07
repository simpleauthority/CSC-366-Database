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

    public CustomerPersonalInfo(int customerInfoId, String name, String phone, String email, String address, Date dateOfBirth) {
        this.customerInfoId = customerInfoId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public int getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(int customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

