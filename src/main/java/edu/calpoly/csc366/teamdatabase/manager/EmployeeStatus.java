package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EmployeeStatus")
public class EmployeeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private int employeeId;
    private Date hireDate;
    private Date termDate;
    private int storeId;
    public EmployeeStatus() {}

    public EmployeeStatus(int statusId, int employeeId, Date hireDate, Date termDate, int storeId) {
        this.statusId = statusId;
        this.employeeId = employeeId;
        this.hireDate = hireDate;
        this.termDate = termDate;
        this.storeId = storeId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getTermDate() {
        return termDate;
    }

    public void setTermDate(Date termDate) {
        this.termDate = termDate;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeStatus that = (EmployeeStatus) o;
        return statusId == that.statusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId);
    }

    @Override
    public String toString() {
        return "EmployeeStatus{" +
                "statusId=" + statusId +
                ", employeeId=" + employeeId +
                ", hireDate=" + hireDate +
                ", termDate=" + termDate +
                ", storeId=" + storeId +
                '}';
    }
}
