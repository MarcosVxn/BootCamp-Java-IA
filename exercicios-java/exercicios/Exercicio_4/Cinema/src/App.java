package Exercicio_4.Cinema.src;

public class App {
     public static void main(String[] args) {

        // Ingresso normal
        Ingresso ingresso = new Ingresso(
                50,
                "Vingadores",
                true
        );

        System.out.println("INGRESSO NORMAL");
        System.out.println(ingresso.getIngresso());
        System.out.println("Valor real: R$ " + ingresso.getValorReal());


        System.out.println("\n-------------------------\n");


        // Meia entrada
        Ingresso meia = new MeiaEntrada(
                50,
                "Vingadores",
                false
        );

        System.out.println("MEIA ENTRADA");
        System.out.println(meia.getIngresso());
        System.out.println("Valor real: R$ " + meia.getValorReal());


        System.out.println("\n-------------------------\n");


        // Ingresso família
        Ingresso familia = new IngressoFamilia(
                50,
                "Vingadores",
                true,
                4
        );

        System.out.println("INGRESSO FAMÍLIA");
        System.out.println(familia.getIngresso());
        System.out.println("Valor real: R$ " + familia.getValorReal());
    }
}
