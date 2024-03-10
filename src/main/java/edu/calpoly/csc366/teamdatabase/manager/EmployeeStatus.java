package edu.calpoly.csc366.teamdatabase.manager;

import edu.calpoly.csc366.teamdatabase.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EmployeeStatus")
public class EmployeeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId", nullable = false)
    private Employee employee;
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Temporal(TemporalType.DATE)
    private Date termDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public EmployeeStatus() {
    }

    public EmployeeStatus(int statusId, Employee employee, Date hireDate, Date termDate, Store store) {
        this.statusId = statusId;
        this.employee = employee;
        this.hireDate = hireDate;
        this.termDate = termDate;
        this.store = store;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                ", employee=" + employee +
                ", hireDate=" + hireDate +
                ", termDate=" + termDate +
                ", store=" + store +
                '}';
    }
}
