package edu.calpoly.csc366.teamdatabase.owner_boardDirector;

import edu.calpoly.csc366.teamdatabase.employee.Role;
import jakarta.persistence.Entity;
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
public class BoardMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardMemberID;

    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Temporal(TemporalType.DATE)
    private Date tenureStart;
    @Temporal(TemporalType.DATE)
    private Date tenureEnd;
    private String phone;

    // Default constructor
    public BoardMember() {
    }

    // Parameterized constructor
    public BoardMember(String firstName, String lastName, Role role, Date tenureStart, Date tenureEnd, String phone) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
