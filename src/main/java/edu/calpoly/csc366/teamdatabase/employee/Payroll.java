package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payrollId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Type type;
    @Column(name = "unitPay", precision = 8, scale = 2)
    private BigDecimal unitPay;
    @Temporal(value = TemporalType.DATE)
    private Date effectiveDate;
    private boolean current;

    public enum Type {
        PART,
        FULL
    }
}
