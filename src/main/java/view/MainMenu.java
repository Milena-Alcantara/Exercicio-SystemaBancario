package view;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
    CustomerView customerView = new CustomerView();
    BankAccountView bankAccountView =  new BankAccountView();
    BankTransactionView bankTransactionView = new BankTransactionView();
    public void mainMenu() throws SQLException {
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Informe a opção desejada: ");
            System.out.println("\n\t1- Registrar um cliente\n\t2- Registrar uma conta\n\t3- Registrar uma transação" +
                    "\n\t4- Verificar transações de uma conta específica\n\t5- Verificar contas de um cliente \n\t6- Sair");

            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    customerView.registerCustomer();
                    break;

                case 2:
                    bankAccountView.registerAccount();
                    break;

                case 3:
                    bankTransactionView.registerTransaction();
                    break;

                case 4:
                    bankTransactionView.findTransaction();
                    break;

                case 5:
                    bankAccountView.findAccounts();
                    break;

                case 6:
                    System.out.println("Encerrando o sistema.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Digite uma opção válida por favor.");

            }
        }while (choice != 6);

    }
}
