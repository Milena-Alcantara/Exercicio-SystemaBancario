package view;

import controller.BankAccoutController;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();

       System.out.println("Bem vindo ao Sistema de Gerenciamento de Banco de Dados!");
       mainMenu.mainMenu();
    }
}
