package Exercicio_1;

import java.util.Scanner;

public class CalculoIdade {

    private static int ANOATUAL = 2026;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual o seu nome? ");
        String nome = scan.next();
        System.out.print("Em que ano você nasceu? ");
        int dataNasc = scan.nextInt();

        int idade = ANOATUAL - dataNasc;

        System.out.println("Ola " + nome + "Você tem " + idade + " anos");


        scan.close();
    }
    
}
