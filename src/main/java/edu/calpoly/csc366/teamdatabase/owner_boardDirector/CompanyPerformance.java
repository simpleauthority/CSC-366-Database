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
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
public class CompanyPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int performanceID;

    @Temporal(TemporalType.DATE)
    private Date performanceDate;
    private int revenue;
    private int profitMargin;
    private float growthRate;
}
