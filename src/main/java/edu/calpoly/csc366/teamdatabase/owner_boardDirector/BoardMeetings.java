package edu.calpoly.csc366.teamdatabase.owner_boardDirector;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

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
