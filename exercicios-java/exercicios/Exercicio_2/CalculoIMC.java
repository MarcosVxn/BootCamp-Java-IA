package Exercicio_2;

import java.util.Scanner;

public class CalculoIMC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Qual o seu peso? ");
        double peso = scan.nextDouble();
        System.out.println("Qual o sua altura? ");
        double altura = scan.nextDouble();

        double IMC = peso/(altura*altura);

        if (IMC < 18.5) {
            System.out.println("Seu Imc esta em " + IMC + " Abaixo do peso");
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            System.out.println("Seu Imc esta em " + IMC + " Peso ideal");
        } else if (IMC >= 25.0 && IMC <= 29.9) {
            System.out.println("Seu Imc esta em " + IMC + " Levemente acima do peso");
        } else if (IMC >= 30.0 && IMC <= 34.9) {
            System.out.println("Seu Imc esta em " + IMC + " Obesidade Grau I");
        } else if (IMC >= 35.0 && IMC <= 39.9) {
            System.out.println("Seu Imc esta em " + IMC + " Obesidade Grau II (Severa)");
        } else if (IMC >= 40.0) {
            System.out.println("Seu Imc esta em " + IMC + " Obesidade Grau III (Mórbida)");
        }
        

        scan.close();
    }
}
