package main.java.edu.calpoly.csc366.teamdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
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
public class StrategicInitiatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statementID;

    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingID", nullable = false)
    private BoardMeetings boardMeeting;

    // Default constructor
    public StrategicInitiatives() {
    }

    // Parameterized constructor
    public StrategicInitiatives(String title, String description, Date startDate, Date endDate, String status, BoardMeetings boardMeeting) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.boardMeeting = boardMeeting;
    }

    // Getters and setters
    public int getStatementID() {
        return statementID;
    }

    public void setStatementID(int statementID) {
        this.statementID = statementID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BoardMeetings getBoardMeeting() {
        return boardMeeting;
    }

    public void setBoardMeeting(BoardMeetings boardMeeting) {
        this.boardMeeting = boardMeeting;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StrategicInitiatives)) return false;
        StrategicInitiatives that = (StrategicInitiatives) o;
        return getStatementID() == that.getStatementID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatementID());
    }

    // toString() method
    @Override
    public String toString() {
        return "StrategicInitiatives{" +
                "statementID=" + statementID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", boardMeetingID=" + (boardMeeting != null ? boardMeeting.getMeetingID() : "null") +
                '}';
    }
}


