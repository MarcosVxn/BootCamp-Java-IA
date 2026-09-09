package Exercicio_2;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Qual Numero da Tabuada: ");
        int NumTabuada = scan.nextInt();

        for(int a = 0; a < 11; a++){
        int resultado = NumTabuada * a;
        System.out.println(NumTabuada +" X "+ a + " = " +resultado);            
        };
        

        scan.close();
    }
}
