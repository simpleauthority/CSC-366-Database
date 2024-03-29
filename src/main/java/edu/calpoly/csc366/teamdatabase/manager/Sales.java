package edu.calpoly.csc366.teamdatabase.manager;

import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;
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
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private SuppliedProduct product;
    private int quantitySold;
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    private int totalSaleAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public Sales() {
    }

    public Sales(SuppliedProduct product, int quantitySold, Date saleDate, int totalSaleAmount) {
        this.product = product;
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

    public SuppliedProduct getProduct() {
        return product;
    }

    public void setProduct(SuppliedProduct product) {
        this.product = product;
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
                ", product=" + product +
                ", quantitySold=" + quantitySold +
                ", saleDate=" + saleDate +
                ", totalSaleAmount=" + totalSaleAmount +
                ", store=" + store +
                '}';
    }
}
