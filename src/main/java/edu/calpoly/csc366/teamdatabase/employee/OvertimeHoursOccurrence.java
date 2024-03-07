package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

@Entity
public class OvertimeHoursOccurrence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int occurrenceId;
    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @Column(name = "amountOvertime", precision = 8, scale = 2)
    private BigDecimal amountOvertime;
    @ManyToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;
}
