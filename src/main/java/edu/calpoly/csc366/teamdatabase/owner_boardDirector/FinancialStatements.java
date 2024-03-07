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
        if (!(o instanceof FinancialStatements that)) return false;
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
