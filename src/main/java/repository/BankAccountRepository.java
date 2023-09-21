package repository;

import model.BankAccountModel;
import model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connectionDB.ConnectionDB.connect;

public class BankAccountRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewAccount(BankAccountModel bankAccountModel) {
        try {
            String SQL = "INSERT INTO bank_accounts(bank_account_number,bank_balance,customer_id) VALUES(?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, bankAccountModel.getAccountNumber());
            pstm.setDouble(2, bankAccountModel.getBalance());
            pstm.setInt(3, bankAccountModel.getFk_customerID());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

    public ResultSet findAccountByCustomerName(CustomerModel customerModel) {
        try {
            String SQL = "SELECT bank_accounts.id,bank_accounts.bank_account_number,bank_accounts.bank_balance " +
                    "FROM bank_accounts,customers WHERE customers.name = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, customerModel.getName());
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;
    }
    public boolean updateBalanceOriginAccountAfterTransaction(int idAccount, Double exitValue) {
        try {
            String SQL = "UPDATE bank_accounts SET bank_balance = bank_balance - "+exitValue+" WHERE id = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idAccount);
            pstm.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }
    public boolean updateBalanceDestinyAccountAfterTransaction(int idAccount, Double addedValue) {
        try {
            String SQL = "UPDATE bank_accounts SET bank_balance = bank_balance + "+addedValue+" WHERE id = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idAccount);
            pstm.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }
}
