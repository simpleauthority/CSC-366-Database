package edu.calpoly.csc366.teamdatabase.owner_boardDirector;

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
public class BoardMeetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingID;

    @Temporal(TemporalType.DATE)
    private Date meetingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardMemberID", nullable = false)
    private BoardMember boardMember;

    private String agenda;
    private String decisions;
    private String actionItems;

    // Default constructor
    public BoardMeetings() {
    }

    // Parameterized constructor
    public BoardMeetings(Date meetingDate, BoardMember boardMember, String agenda, String decisions, String actionItems) {
        this.meetingDate = meetingDate;
        this.boardMember = boardMember;
        this.agenda = agenda;
        this.decisions = decisions;
        this.actionItems = actionItems;
    }

    // Getters and setters
    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public BoardMember getBoardMember() {
        return boardMember;
    }

    public void setBoardMember(BoardMember boardMember) {
        this.boardMember = boardMember;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getDecisions() {
        return decisions;
    }

    public void setDecisions(String decisions) {
        this.decisions = decisions;
    }

    public String getActionItems() {
        return actionItems;
    }

    public void setActionItems(String actionItems) {
        this.actionItems = actionItems;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardMeetings)) return false;
        BoardMeetings that = (BoardMeetings) o;
        return getMeetingID() == that.getMeetingID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMeetingID());
    }

    // toString() method
    @Override
    public String toString() {
        return "BoardMeetings{" +
                "meetingID=" + meetingID +
                ", meetingDate=" + meetingDate +
                ", agenda='" + agenda + '\'' +
                ", decisions='" + decisions + '\'' +
                ", actionItems='" + actionItems + '\'' +
                '}';
    }
}
