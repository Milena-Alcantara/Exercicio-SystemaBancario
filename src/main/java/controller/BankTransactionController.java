package controller;

import model.BankTransactionModel;
import repository.BankTransactionRepository;

import java.sql.ResultSet;

public class BankTransactionController {
    BankTransactionRepository bankTransactionRepository;
    public BankTransactionController() {
      bankTransactionRepository = new BankTransactionRepository();
    }
    public boolean registerNewTransaction(BankTransactionModel bankTransactionModel){
        return bankTransactionRepository.registerNewTransaction(bankTransactionModel);
    }
    public ResultSet findTransactionsByAccountNumber(String numberAccout){
        return bankTransactionRepository.findTransactionsByAccountNumber(numberAccout);
    }
}
