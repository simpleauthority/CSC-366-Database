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
public class EmployeeRecognition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recognitionId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String managerComment;
    @Temporal(value = TemporalType.DATE)
    private Date eventDate;
}
