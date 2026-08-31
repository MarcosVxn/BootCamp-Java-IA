package Exercicio_1;

import java.util.Scanner;

public class CalculoIdade {

    private static final int ANO_ATUAL = 2026;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual o seu nome? ");
        String Nome = scan.nextLine();
        System.out.print("Em que ano você nasceu? ");
        int AnoNasc = scan.nextInt();

        int Idade = ANO_ATUAL - AnoNasc;

        System.out.println("Ola " + Nome + "Você tem " + Idade + " anos");


        scan.close();
    }
    
}
