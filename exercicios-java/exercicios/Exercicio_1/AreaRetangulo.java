package Exercicio_1;

import java.util.Scanner;

public class AreaRetangulo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Tamanho do lado do retangulo? ");
        double lado = scan.nextDouble();
        System.out.println("Tamanho da base do retangulo? ");
        double base = scan.nextDouble();

        
        double area = base * lado;

        System.out.println("A área do seu quadrado é: " + area);

        scan.close();
    }

}
