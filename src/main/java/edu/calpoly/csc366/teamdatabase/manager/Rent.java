package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;
import jdk.jfr.Description;

import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;
    private int storeId;
    private String ExpenseType;
    private String Description;
    private float amount;
    private Date dueDate;
    private Date paymentDate;
    private String Note;
    public Rent() {}

    public Rent(int rentId, int storeId, String expenseType, String description, float amount, Date dueDate, Date paymentDate, String note) {
        this.rentId = rentId;
        this.storeId = storeId;
        ExpenseType = expenseType;
        Description = description;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        Note = note;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getExpenseType() {
        return ExpenseType;
    }

    public void setExpenseType(String expenseType) {
        ExpenseType = expenseType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
