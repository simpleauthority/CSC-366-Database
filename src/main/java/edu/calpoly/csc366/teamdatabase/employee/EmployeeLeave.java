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
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requestId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Temporal(value = TemporalType.DATE)
    private Date leaveStart;
    @Temporal(value = TemporalType.DATE)
    private Date leaveEnd;
    private Type leaveType;
    private boolean managerApproved;

    public enum Type {
        VACATION,
        SICK,
        OTHER
    }
}
