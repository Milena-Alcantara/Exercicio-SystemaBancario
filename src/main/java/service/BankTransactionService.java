package service;

import controller.BankAccoutController;
import controller.BankTransactionController;
import model.BankTransactionModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class BankTransactionService {
    BankTransactionController bankTransactionController;
    BankTransactionModel bankTransactionModel;
    BankAccoutController bankAccoutController;

    public BankTransactionService() {
        bankTransactionModel = new BankTransactionModel();
        bankTransactionController = new BankTransactionController();
    }
    public boolean registerTransaction(java.sql.Date date, Double value, int accountOrigin,int accountDestiny){
        if (!validateValueTransaction(value)){
            System.out.println("Informe um valor válido para a transação. ");
            return false;
        }
        bankTransactionModel.setTransactionDate(date);
        bankTransactionModel.setTransactionValue(value);
        bankTransactionModel.setFk_OriginAccountID(accountOrigin);
        bankTransactionModel.setFk_DetinyAccountID(accountDestiny);
        bankTransactionController.registerNewTransaction(bankTransactionModel);
        return true;
    }
    public boolean findTransactions(String numberAccount) throws SQLException {
        ResultSet resultSet = bankTransactionController.findTransactionsByAccountNumber(numberAccount);
        if (resultSet == null){
            System.out.println("Não foi possível localizar a conta. ");
            return false;
        }
        while (resultSet.next()){
            System.out.println("ID DA TRANSAÇÃO: "+resultSet.getInt("id"));
            System.out.println("DATA: "+resultSet.getDate("transaction_date"));
            System.out.println("VALOR: "+resultSet.getDouble("transaction_value"));
            System.out.println("ID CONTA DESTINO: "+resultSet.getInt("destiny_account_id"));
            System.out.println();
        }
        return true;
    }

    public boolean validateValueTransaction(Double value){
        return value>0;
    }
}
