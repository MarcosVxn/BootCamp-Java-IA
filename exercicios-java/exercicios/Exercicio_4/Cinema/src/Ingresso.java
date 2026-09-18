package Exercicio_4.Cinema.src;

public sealed class Ingresso permits IngressoFamilia, MeiaEntrada {
    protected double valor;

    protected String nomeFilme;

    protected Boolean dublado = false;

    public Ingresso(double valor, String nomeFilme, Boolean dublado){
        setValorOriginal(valor);
        setNomeFilme(nomeFilme);
        setDublado(dublado);
    }

    public void setValorOriginal(double valor){
        this.valor = valor;
    }

    public double getValorReal(){
    return this.valor;
    }


    public void setNomeFilme(String nomeFilme){
        this.nomeFilme = nomeFilme;
    }

    public void setDublado(Boolean dublado){
        this.dublado = dublado;
        
    }

    public double getValorFilme(){
        return this.valor;
    }

    public String getNomeFilme(){
        return this.nomeFilme;
    }

    public Boolean getDublado(){
        return this.dublado;
    }
    public String tipoAudio(){
        String tipoAudio = dublado ? "Dublado" : "Legendado";

        return tipoAudio;
    }

    public String getIngresso(){
        return "Filme: " + nomeFilme
       + " | " + tipoAudio()
       + " | Valor total: R$ " + valor;
    }
}
