package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class EmployeeSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int surveyId;
    private String surveyTitle;
    private String surveyDescription;
    @Temporal(value = TemporalType.DATE)
    private Date surveyStart;
    @Temporal(value = TemporalType.DATE)
    private Date surveyEnd;
}
