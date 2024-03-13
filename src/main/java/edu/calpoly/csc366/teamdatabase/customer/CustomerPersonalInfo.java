package edu.calpoly.csc366.teamdatabase.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
public class CustomerPersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerInfoId;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    @Size(min=10, max=15)
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String address;

    @NotNull
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

    public CustomerPersonalInfo() {

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

