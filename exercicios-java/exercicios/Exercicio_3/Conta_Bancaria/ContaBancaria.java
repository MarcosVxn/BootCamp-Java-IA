package Conta_Bancaria;


public class ContaBancaria {


    private final int VALOR_MIN_SALDO = 500;
    private final int VALOR_MIN_CHEQUE = 50;


    private int saldo;
    private double chequeEspecial;
    private int ValorBoleto;
    
    public ContaBancaria(){
        
    }

    public ContaBancaria(int saldo, double chequeEspecial){
        setSaldo(saldo);
        setCheque();
    }

    public void setSaldo(int saldo){

        if (saldo <= 0 ) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }

        this.saldo = saldo;
    }

    public void setCheque(){

        if (this.saldo <= VALOR_MIN_SALDO) {
            this.chequeEspecial = VALOR_MIN_CHEQUE;
        }
        if (this.saldo > VALOR_MIN_SALDO) {
            double Cheque_Acima = saldo * 0.5;
            this.chequeEspecial = Cheque_Acima;
        }
    }

    public void pagarBoleto(int ValorBoleto){
        if (ValorBoleto > saldo && ValorBoleto > chequeEspecial ) {
            System.out.println("Voce não possui Saldo e nem cheque Especial");
        }
        if(ValorBoleto > saldo){
            double taxa = ValorBoleto * 0.20;

            ValorBoleto -= chequeEspecial;
            this.chequeEspecial -= taxa;

            System.out.println("Voce pagou com Cheque especial");
        }

        ValorBoleto -= saldo;
        System.out.println("Voce pagou o boleto");
    }

    public void setValorBoleto(){
        this.ValorBoleto = ValorBoleto;
    }


    public int getSaldo(){
        return this.saldo;
    }

    public double getCheque(){
        return this.chequeEspecial;
    }


}
