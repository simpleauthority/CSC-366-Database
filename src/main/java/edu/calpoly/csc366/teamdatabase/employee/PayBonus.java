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
public class PayBonus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bonusId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "bonusAmount", precision = 6, scale = 2)
    private BigDecimal bonusAmount;
    @Temporal(value = TemporalType.DATE)
    private Date dateApplied;
}
