package Exercicio_4.Cinema.src;

public non-sealed class IngressoFamilia extends Ingresso {
    
    private int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme,Boolean dublado, int numeroPessoas){
        super(valor, nomeFilme, dublado);
        setNumeroPessoas(numeroPessoas);
    }

    public void setNumeroPessoas(int numeroPessoas){
        this.numeroPessoas = numeroPessoas;
    }

    public int getNumeroPessoas(){
        return numeroPessoas;
    }


    @Override 
    public double getValorReal(){
        double total = valor * numeroPessoas;
        if (numeroPessoas > 3) {
            total = total - (total *0.05);
        }

        return total;
    }
}
