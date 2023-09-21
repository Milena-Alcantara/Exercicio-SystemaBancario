package controller;

import model.CustomerModel;
import repository.CustomerRepository;

public class CustomerController {
    CustomerRepository customerRepository;

    public CustomerController() {
        customerRepository = new CustomerRepository();
    }

    public boolean registerNewCustomer(CustomerModel customerModel){
        return customerRepository.registerNewCustomer(customerModel);
    }
}
