package Exercicio_4.Cinema.src;

public non-sealed class MeiaEntrada extends Ingresso{

    private final double DIVISOR_MEIA = 2;
    
    public MeiaEntrada(double valor, String nomeFilme, Boolean dublado) {
        super(valor, nomeFilme, dublado);
        
    }
    
    @Override 
    public double getValorReal(){
        double total = valor / DIVISOR_MEIA;

        return total;
    }
}
