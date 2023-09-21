package model;

import java.util.Date;

public class BankTransactionModel {
    private int id;
    private java.sql.Date transactionDate;
    private Double transactionValue;
    private int fk_OriginAccountID, fk_DetinyAccountID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(java.sql.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public int getFk_OriginAccountID() {
        return fk_OriginAccountID;
    }

    public void setFk_OriginAccountID(int fk_OriginAccountID) {
        this.fk_OriginAccountID = fk_OriginAccountID;
    }

    public int getFk_DetinyAccountID() {
        return fk_DetinyAccountID;
    }

    public void setFk_DetinyAccountID(int fk_DetinyAccountID) {
        this.fk_DetinyAccountID = fk_DetinyAccountID;
    }
}
