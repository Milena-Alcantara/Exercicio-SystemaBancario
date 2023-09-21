package view;

import service.CustomerService;

import java.util.Scanner;

public class CustomerView {
    Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    public void registerCustomer(){
        System.out.print("Informe seu nome completo: ");
        String name = scanner.nextLine();
        System.out.print("Informe seu CPF ");
        String cpf = scanner.nextLine();
        System.out.print("Informe seu endereço: ");
        String address = scanner.nextLine();

        if (customerService.registerCustomer(name,cpf,address)){
            System.out.println("Cliente foi cadastrado com sucesso! ");
        }else {
            System.out.println("Não foi possível efetuar cadastro, revise seus dados e tente novamente.");
        }

    }
}
