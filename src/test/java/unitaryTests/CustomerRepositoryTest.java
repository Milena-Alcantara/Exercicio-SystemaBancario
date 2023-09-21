package unitaryTests;

import model.CustomerModel;
import org.junit.jupiter.api.Test;
import repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerRepositoryTest {
    private CustomerRepository customerRepository = new CustomerRepository();
    CustomerModel customerModel = new CustomerModel("Milena Lopes","123.456.789-01","Av Lorem ipsum" +
            " Nº 5");

    @Test
    public void testRegisterNewCustomer(){
        boolean result = customerRepository.registerNewCustomer(customerModel);
        assertTrue(result);
    }

}
