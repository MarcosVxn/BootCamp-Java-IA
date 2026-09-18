package Conta_Bancaria;
import Conta_Bancaria.ContaBancaria;

import java.util.Scanner;


public class App {
    
    public final static Scanner scanner = new Scanner(System.in);

    private static ContaBancaria Conta = new ContaBancaria();
    public static void main(String[] args) {
        var options = -1;
        do {
            System.out.println("===Escolha uma das opções===");
            System.out.println("1- Criar conta");
            System.out.println("2- Adicionar Saldo");
            System.out.println("3- Verificar Saldo");
            System.out.println("4- Verificar Cheque Especial");
            System.out.println("5- Pagar Boleto");
            System.out.println("6- Sacar Dinheiro");
            System.out.println("7- Verificar se a conta está usando cheque especial");
            System.out.println("0- sair");
            System.out.println("========");
            options = scanner.nextInt();

            switch (options) {
                case 1 -> CriarConta();
                case 2 -> AdicionarSaldo();
                case 3 -> VerificarSaldo();
                case 4 -> VerificarCheque();
                case 5 -> PagarBoleto();
            }

        } while (true);
    }

    
    
    public static void CriarConta(){
        
        System.out.println("Criando Conta ===");
        System.out.println("Informe seu saldo");
        int saldo = scanner.nextInt();
        if (saldo <= 0 ) {
            System.out.println("Saldo não pode ser negativo");
        }
        
        Conta = new ContaBancaria(saldo, saldo);
        System.out.println("Sua conta foi criada com sucesso e possui " + Conta.getSaldo() + " de saldo");
        System.out.println("e possui " + Conta.getCheque() + " de cheque especial");
    }
    
    public static void AdicionarSaldo(){
        System.out.println("=== Adicionando Saldo ==="); 
        System.out.println("Informe o Saldo a adicionar: ");
        int saldo = scanner.nextInt();
        
        Conta.adicionarSaldo(saldo);
        
        System.out.println("Voce adicionou " + saldo + " a sua conta");
        
        System.out.println("Voce Possui R$" + Conta.getSaldo() + " de Saldo");
        
        System.out.println("E Possui R$" + Conta.getCheque() + " de Cheque Especial");
    }
    
    public static void VerificarSaldo(){
        System.out.println("Seu Saldo Atual é de R$" + Conta.getSaldo());
    }
    
    public static void VerificarCheque(){
        System.out.println("Seu Cheque Atual é de R$" + Conta.getCheque());
    }

    public static void PagarBoleto(){
        System.out.println("=== Pagando Boleto ===");
        System.out.println(" Valor do Boleto ");
        int valorBoleto = scanner.nextInt();

        Conta.pagarBoleto(valorBoleto);
    }

}
