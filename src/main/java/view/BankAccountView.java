package view;

import service.BankAccountService;
import service.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class BankAccountView {
    Scanner scanner = new Scanner(System.in);
   BankAccountService bankAccountService = new BankAccountService();
    public void registerAccount(){
        System.out.print("Informe o número da conta: ");
        String number = scanner.nextLine();
        System.out.print("Informe o saldo inicial:  ");
        Double balance = scanner.nextDouble();
        System.out.print("Informe o id do cliente reponsável pela conta: ");
        int idCustomer = scanner.nextInt();

        if (bankAccountService.registerAccount(number,balance,idCustomer)){
            System.out.println("Conta cadastrada com sucesso! ");
        }else {
            System.out.println("Não foi possível efetuar cadastro, revise seus dados e tente novamente.");
        }
    }

    public void findAccounts() throws SQLException {
        System.out.println("Digite o nome do cliente que deseja localizar as contas cadatradas: ");
        String nameCustomer = scanner.nextLine();
        if (bankAccountService.findAccount(nameCustomer)){
            System.out.println("Fim da pesquisa. ");
        }else {
            System.out.println("Não foi possível localizar. ");
        }
    }

}
