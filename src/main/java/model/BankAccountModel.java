package model;

public class BankAccountModel {
    private int id;
    private String accountNumber;
    private Double balance;
    private int fk_customerID;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getFk_customerID() {
        return fk_customerID;
    }

    public void setFk_customerID(int fk_customerID) {
        this.fk_customerID = fk_customerID;
    }
}
