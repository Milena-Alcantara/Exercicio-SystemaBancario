package unitaryTests;

import model.BankTransactionModel;
import org.junit.jupiter.api.Test;
import repository.BankTransactionRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTransactionRepositoryTest {
    BankTransactionRepository bankTransactionRepository = new BankTransactionRepository();

    @Test
    public void testRegisterNewTransaction(){
        BankTransactionModel bankTransactionModel = new BankTransactionModel(Date.valueOf("2023-09-20"),10.00
        ,2,1);
        boolean result = bankTransactionRepository.registerNewTransaction(bankTransactionModel);
        assertTrue(result);
    }
    @Test
    public void testFindTransactionsByAccountNumber() throws SQLException {
        ResultSet resultSet = bankTransactionRepository.findTransactionsByAccountNumber("65432-1");
        assertNotNull(resultSet);

        while (resultSet.next()){
            assertEquals(1, resultSet.getInt("id"));
            assertEquals(Date.valueOf("2023-09-20"), resultSet.getDate("transaction_date"));
            assertEquals(10.00,resultSet.getDouble("transaction_value"));
            assertEquals(1,resultSet.getInt("destiny_account_id"));
        }
    }
}
