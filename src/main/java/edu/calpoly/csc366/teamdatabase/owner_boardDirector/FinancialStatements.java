package main.java.edu.calpoly.csc366.teamdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
public class FinancialStatements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statementID;

    private String type;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int totalAssets;
    private int totalLiabilities;
    private int netIncome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardMemberID", nullable = false)
    private BoardMember boardMember;
}
