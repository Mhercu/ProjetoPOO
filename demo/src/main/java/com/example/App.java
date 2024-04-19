package com.example;

import com.example.controllers.ClienteController;
import com.example.controllers.FaturaController;
import com.example.controllers.ProdutoController;
import com.example.controllers.CompraController; 
import com.example.models.ClienteModel;
import com.example.models.FaturaModel;
import com.example.models.ProdutoModel;
import com.example.models.CompraModel; 
import com.example.view.ClienteView;
import com.example.view.FaturaView;
import com.example.view.ProdutoView;
import com.example.view.CompraView; 

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "CP850");
        ClienteModel clienteModel = new ClienteModel();
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteModel, clienteView);

        FaturaModel faturaModel = new FaturaModel();
        FaturaView faturaView = new FaturaView();
        FaturaController faturaController = new FaturaController(faturaModel, faturaView);

        ProdutoModel produtoModel = new ProdutoModel();
        ProdutoView produtoView = new ProdutoView();
        ProdutoController produtoController = new ProdutoController(produtoModel, produtoView);

        CompraModel compraModel = new CompraModel(); 
        CompraView compraView = new CompraView(); 
        CompraController compraController = new CompraController(compraModel, compraView);

        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Operações do Cliente");
            System.out.println("2. Operações de Fatura");
            System.out.println("3. Operações de Produto");
            System.out.println("4. Operações de Compra"); 
            System.out.println("5. Sair"); 
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nMenu Cliente:");
                    clienteController.iniciar();
                    break;
                case 2:
                    System.out.println("\nMenu Fatura:");
                    faturaController.iniciar();
                    break;
                case 3:
                    System.out.println("\nMenu Produto:");
                    produtoController.iniciar();
                    break;
                case 4:
                    System.out.println("\nMenu Compra:"); 
                    compraController.iniciar();
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 5); 
    }
}
