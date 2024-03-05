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
public class FinancialStatements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statementID;

    private String type;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int totalAssets;
    private int totalLiabilities;
    private int netIncome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardMemberID", nullable = false)
    private BoardMember boardMember;

    // Default constructor
    public FinancialStatements() {
    }

    // Parameterized constructor
    public FinancialStatements(String type, Date date, int totalAssets, int totalLiabilities, int netIncome, BoardMember boardMember) {
        this.type = type;
        this.date = date;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.netIncome = netIncome;
        this.boardMember = boardMember;
    }

    // Getters and setters
    public int getStatementID() {
        return statementID;
    }

    public void setStatementID(int statementID) {
        this.statementID = statementID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(int totalAssets) {
        this.totalAssets = totalAssets;
    }

    public int getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(int totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public BoardMember getBoardMember() {
        return boardMember;
    }

    public void setBoardMember(BoardMember boardMember) {
        this.boardMember = boardMember;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinancialStatements)) return false;
        FinancialStatements that = (FinancialStatements) o;
        return getStatementID() == that.getStatementID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatementID());
    }

    // toString() method
    @Override
    public String toString() {
        return "FinancialStatements{" +
                "statementID=" + statementID +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", totalAssets=" + totalAssets +
                ", totalLiabilities=" + totalLiabilities +
                ", netIncome=" + netIncome +
                ", boardMember=" + (boardMember != null ? boardMember.getBoardMemberID() : "null") +
                '}';
    }
}
