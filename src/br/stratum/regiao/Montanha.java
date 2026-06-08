package br.stratum.regiao;

public class Montanha extends Regiao{
    private double inclinacao;
    private double saturacaoSolo;

    public Montanha(String nome, double area, double tendencia, double declive, double erosao) {
        super(nome, area, tendencia);
        this.inclinacao = declive;
        this.saturacaoSolo = erosao;
    }

    @Override
    public double calcularRisco() {
        double risco = (inclinacao / 90) * 60 + saturacaoSolo * 0.40 ;
        if (risco > 100){
            risco = 100;
        }
        return risco;
    }

    public double getInclinacao() {
        return inclinacao;
    }

    public double getSaturacaoSolo() {
        return saturacaoSolo;
    }


}
