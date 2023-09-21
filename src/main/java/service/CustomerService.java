package service;

import controller.CustomerController;
import model.CustomerModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService {
    CustomerController customerController;
    CustomerModel customerModel;
    public CustomerService() {
       customerController = new CustomerController();
       customerModel = new CustomerModel();
    }

    public boolean registerCustomer(String name, String cpf, String address){
        if (validateString(name, address) && validateCpf(cpf)){
            customerModel.setName(name);
            customerModel.setCpf(cpf);
            customerModel.setAddress(address);
            customerController.registerNewCustomer(customerModel);
            return true;
        }
        return false;
    }

    public boolean validateCpf(String cpf){
        String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(\\d{11})$";
        Pattern pattern = Pattern.compile(regex);
        cpf = cpf.replaceAll("[^0-9]", "");
        Matcher matcher = pattern.matcher(cpf);
        if ( !cpf.isEmpty() && matcher.matches() && cpf.length()==11){
            return true;
        }
        return false;
    }
    public boolean validateString(String name, String address){
        if (!name.isEmpty() && !address.isEmpty()){
            return true;
        }
        return false;
    }
}
