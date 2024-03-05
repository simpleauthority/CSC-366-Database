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
        if (!(o instanceof ShareholderEngagement)) return false;
        ShareholderEngagement that = (ShareholderEngagement) o;
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
