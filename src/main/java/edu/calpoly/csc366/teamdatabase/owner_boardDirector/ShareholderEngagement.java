package edu.calpoly.csc366.teamdatabase.owner_boardDirector;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.Objects;

@Entity
public class ShareholderEngagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int engagementID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingID", nullable = false)
    private BoardMeetings boardMeeting;

    private Date date;
    private String feedback;
    private String communication;

    // Default constructor
    public ShareholderEngagement() {
    }

    // Parameterized constructor
    public ShareholderEngagement(BoardMeetings boardMeeting, Date date, String feedback, String communication) {
        this.boardMeeting = boardMeeting;
        this.date = date;
        this.feedback = feedback;
        this.communication = communication;
    }

    // Getters and setters
    public int getEngagementID() {
        return engagementID;
    }

    public void setEngagementID(int engagementID) {
        this.engagementID = engagementID;
    }

    public BoardMeetings getBoardMeeting() {
        return boardMeeting;
    }

    public void setBoardMeeting(BoardMeetings boardMeeting) {
        this.boardMeeting = boardMeeting;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShareholderEngagement that)) return false;
        return getEngagementID() == that.getEngagementID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngagementID());
    }

    // toString() method
    @Override
    public String toString() {
        return "ShareholderEngagement{" +
                "engagementID=" + engagementID +
                ", boardMeetingID=" + (boardMeeting != null ? boardMeeting.getMeetingID() : "null") +
                ", date=" + date +
                ", feedback='" + feedback + '\'' +
                ", communication='" + communication + '\'' +
                '}';
    }
}
