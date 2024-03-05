package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int saleId;
    private int storeId;
    private int productId;
    private int quantitySold;
    private Date saleDate;
    private int totalSaleAmount;

    public Sales () {}

    public Sales(int saleId, int storeId, int productId, int quantitySold, Date saleDate, int totalSaleAmount) {
        this.saleId = saleId;
        this.storeId = storeId;
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
        this.totalSaleAmount = totalSaleAmount;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(int totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return saleId == sales.saleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", storeId=" + storeId +
                ", productId=" + productId +
                ", quantitySold=" + quantitySold +
                ", saleDate=" + saleDate +
                ", totalSaleAmount=" + totalSaleAmount +
                '}';
    }
}
