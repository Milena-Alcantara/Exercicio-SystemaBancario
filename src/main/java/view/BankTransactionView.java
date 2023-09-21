package view;

import controller.BankAccoutController;
import service.BankAccountService;
import service.BankTransactionService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class BankTransactionView {
    Scanner scanner = new Scanner(System.in);
    BankTransactionService bankTransactionService = new BankTransactionService();
    BankAccoutController bankAccoutController = new BankAccoutController();
    public void registerTransaction(){
        System.out.print("Informe a data da transação: ");
        java.sql.Date date = Date.valueOf(scanner.next());
        System.out.print("Informe o valor a transferir:  ");
        Double value = scanner.nextDouble();
        System.out.print("Informe o id da conta de origem: ");
        int idOrigin = scanner.nextInt();
        System.out.print("Informe o id da conta de destino: ");
        int idDestiny = scanner.nextInt();

        if (bankTransactionService.registerTransaction(date,value,idOrigin,idDestiny)){
            bankAccoutController.updateBalanceDestinyAccountAfterTransaction(idOrigin,value);
            bankAccoutController.updateBalanceDestinyAccountAfterTransaction(idDestiny,value);
            System.out.println("Transação realizada com sucesso! ");
        }else {
            System.out.println("Não foi possível realizar a transação, verifique os dados e tente novamente.");
        }
    }
    public void findTransaction() throws SQLException {
        scanner.nextLine();
        System.out.println("Informe o número da conta que deseja localizar: ");
        String numberAccount = scanner.next();
        if (bankTransactionService.findTransactions(numberAccount)){
            System.out.println();
            System.out.println("Fim dos resultados.");
        }
    }
}
