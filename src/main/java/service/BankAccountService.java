package service;

import controller.BankAccoutController;
import model.BankAccountModel;
import model.CustomerModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountService {
    BankAccoutController bankAccoutController;
    BankAccountModel bankAccountModel;
    CustomerModel customerModel;

    public BankAccountService() {
        bankAccoutController = new BankAccoutController();
        bankAccountModel = new BankAccountModel();
        customerModel = new CustomerModel();
    }

    public boolean registerAccount(String numberAccount, Double balance, int  idClient){
        if (!validateNumberAccount(numberAccount)){
            System.out.println("Número de conta inválido, toda conta possui 7 digitos incluindo o traço verificador.");
            return false;
        } else if (!validateBalance(balance)) {
            System.out.println("O saldo não pode começar negativo. ");
            return false;
        }
        bankAccountModel.setAccountNumber(numberAccount);
        bankAccountModel.setBalance(balance);
        bankAccountModel.setFk_customerID(idClient);

        if (!bankAccoutController.registerNewAccount(bankAccountModel)){
            System.out.println("Não foi localizado o cliente para associação da nova conta.");
            return false;
        }
        return true;

    }
    public boolean findAccount(String nameCustomer) throws SQLException {
        if (validateNameCustomer(nameCustomer)){
            System.out.println("O nome não pode ser vazio! ");
            return false;
        }else {
            customerModel.setName(nameCustomer);
            ResultSet resultSet = bankAccoutController.findAccountByCustomerName(customerModel);
            if ( resultSet == null){
                System.out.println("Não há dados para o cliente selecionado.");
                return false;
            }else {
                while (resultSet.next()){
                    System.out.println("ID CONTA: "+resultSet.getInt("id"));
                    System.out.println("NÚMERO DA CONTA: "+resultSet.getString("bank_account_number"));
                    System.out.println("SALDO: "+resultSet.getDouble("bank_balance"));
                    System.out.println();
                }
            }
        }
        return true;
    }

    public boolean validateNumberAccount(String numberAccount){
        return numberAccount.length()==7;
    }
    public boolean validateBalance(Double balance){
        return balance>=0;
    }
    public boolean validateNameCustomer(String nameCustomer){
        return nameCustomer.isEmpty();
    }

    
}
