package controller;

import model.BankAccountModel;
import model.CustomerModel;
import repository.BankAccountRepository;

import java.sql.ResultSet;

public class BankAccoutController {
    BankAccountRepository bankAccountRepository;

    public BankAccoutController() {
        bankAccountRepository = new BankAccountRepository();
    }

    public boolean registerNewAccount(BankAccountModel bankAccountModel){
        return bankAccountRepository.registerNewAccount(bankAccountModel);
    }
    public ResultSet findAccountByCustomerName(CustomerModel customerModel){
        return bankAccountRepository.findAccountByCustomerName(customerModel);
    }
    public boolean updateBalanceOriginAccountAfterTransaction(int idAccount, Double exitValue){
        return  bankAccountRepository.updateBalanceOriginAccountAfterTransaction(idAccount,exitValue);
    }
    public boolean updateBalanceDestinyAccountAfterTransaction(int idAccount, Double addedValue){
        return bankAccountRepository.updateBalanceDestinyAccountAfterTransaction(idAccount,addedValue);
    }
}
