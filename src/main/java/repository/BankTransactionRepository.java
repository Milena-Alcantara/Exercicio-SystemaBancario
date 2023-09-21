package repository;

import model.BankAccountModel;
import model.BankTransactionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connectionDB.ConnectionDB.connect;

public class BankTransactionRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewTransaction(BankTransactionModel bankTransactionModel) {
        try {
            String SQL = "INSERT INTO bank_transaction(transaction_date,transaction_value,origin_account_id,destiny_account_id) " +
                    " VALUES(?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setDate(1, bankTransactionModel.getTransactionDate());
            pstm.setDouble(2, bankTransactionModel.getTransactionValue());
            pstm.setInt(3, bankTransactionModel.getFk_OriginAccountID());
            pstm.setInt(4, bankTransactionModel.getFk_DetinyAccountID());
            pstm.executeUpdate();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

    public ResultSet findTransactionsByAccountNumber(String numberAccout) {
        try {
            String SQL = "SELECT bank_transaction.id,bank_transaction.transaction_date, bank_transaction.transaction_value, " +
                    "bank_transaction.destiny_account_id " +
                    "FROM bank_transaction, bank_accounts WHERE bank_accounts.bank_account_number = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1,numberAccout);
            ResultSet resultSet = pstm.executeQuery();
            return resultSet;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;
    }

}
