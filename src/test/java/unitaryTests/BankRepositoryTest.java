package unitaryTests;

import model.BankAccountModel;
import model.CustomerModel;
import org.junit.jupiter.api.Test;
import repository.BankAccountRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class BankRepositoryTest {
    private BankAccountRepository bankRepository = new BankAccountRepository();

    @Test
    public void testRegisterNewBankAccount(){
        BankAccountModel bankAccountModel = new BankAccountModel("65432-1",20.00,1);
        boolean result = bankRepository.registerNewAccount(bankAccountModel);
        assertTrue(result);
    }

    @Test
    public void testFindAccountByCustomerName() throws SQLException {
        CustomerModel customerModel = new CustomerModel("Fernanda Ferraz","123.456.789-01","Av Lorem ipsum" +
                " Nº 7");

        BankAccountModel bankAccountModel = new BankAccountModel("1111-1",20.00,2);

        ResultSet resultSet = bankRepository.findAccountByCustomerName(customerModel);
        assertNotNull(resultSet);
        while (resultSet.next()){
            assertEquals(2, resultSet.getInt("id"));
            assertEquals("1111-1", resultSet.getString("bank_account_number"));
            assertEquals(20.00,resultSet.getDouble("bank_balance"));
        }
    }
    @Test
    public void testUpdateBalanceOriginAccountAfterTransaction(){
        boolean result = bankRepository.updateBalanceOriginAccountAfterTransaction(2,10.00);
        assertTrue(result);
    }

    @Test
    public void testUpdateBalanceDestinyAccountAfterTransaction(){
        boolean result = bankRepository.updateBalanceDestinyAccountAfterTransaction(1,10.00);
        assertTrue(result);
    }

}
