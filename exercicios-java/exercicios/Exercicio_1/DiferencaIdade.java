package Exercicio_1;

import java.util.Scanner;

public class DiferencaIdade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Qual sua idade?");
        int Idade1 = scan.nextInt();
        System.out.println("Qual sua idade?");
        int Idade2 = scan.nextInt();

        int Diferenca = Idade1 - Idade2;

        System.out.println("Vocês tem a diferença de " + Diferenca + " idades");


        scan.close();
    }
}
