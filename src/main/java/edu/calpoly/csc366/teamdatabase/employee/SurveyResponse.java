package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int responseId;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private EmployeeSurvey survey;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String response;
}
