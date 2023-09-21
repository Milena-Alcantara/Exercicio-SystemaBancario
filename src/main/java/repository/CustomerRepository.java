package repository;

import model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static connectionDB.ConnectionDB.connect;

public class CustomerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewCustomer(CustomerModel customerModel) {
        try {
            String SQL = "INSERT INTO customers(name,cpf,address) VALUES(?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, customerModel.getName());
            pstm.setString(2, customerModel.getCpf());
            pstm.setString(3, customerModel.getAddress());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

}
