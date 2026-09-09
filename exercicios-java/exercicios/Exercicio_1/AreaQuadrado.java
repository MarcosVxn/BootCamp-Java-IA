package Exercicio_1;

import java.util.Scanner;

public class AreaQuadrado {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Tamanho do lado do quadrado? ");
        double lado = scan.nextDouble();
        double area = lado * lado;

        System.out.println("A área do seu quadrado é: " + area);

        scan.close();
    }
}
