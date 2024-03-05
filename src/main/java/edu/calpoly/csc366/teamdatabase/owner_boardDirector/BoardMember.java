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
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
public class BoardMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardMemberID;

    private String firstName;
    private String lastName;
    private String role;
    @Temporal(TemporalType.DATE)
    private Date tenureStart;
    @Temporal(TemporalType.DATE)
    private Date tenureEnd;
    private String phone;

    // Default constructor
    public BoardMember() {
    }

    // Parameterized constructor
    public BoardMember(String firstName, String lastName, String role, Date tenureStart, Date tenureEnd, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.tenureStart = tenureStart;
        this.tenureEnd = tenureEnd;
        this.phone = phone;
    }

    // Getters and setters
    public int getBoardMemberID() {
        return boardMemberID;
    }

    public void setBoardMemberID(int boardMemberID) {
        this.boardMemberID = boardMemberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getTenureStart() {
        return tenureStart;
    }

    public void setTenureStart(Date tenureStart) {
        this.tenureStart = tenureStart;
    }

    public Date getTenureEnd() {
        return tenureEnd;
    }

    public void setTenureEnd(Date tenureEnd) {
        this.tenureEnd = tenureEnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardMember)) return false;
        BoardMember that = (BoardMember) o;
        return getBoardMemberID() == that.getBoardMemberID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBoardMemberID());
    }

    // toString() method
    @Override
    public String toString() {
        return "BoardMember{" +
                "boardMemberID=" + boardMemberID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", tenureStart=" + tenureStart +
                ", tenureEnd=" + tenureEnd +
                ", phone='" + phone + '\'' +
                '}';
    }
}
