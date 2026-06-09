package br.stratum.regiao;

import br.stratum.interfaces.Monitoramento;
import br.stratum.interfaces.Projecao;

public class Montanha extends Regiao implements Monitoramento, Projecao {
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

    @Override
    public double monitoramento() {
        return 0;
    }

    @Override
    public double projecao() {
        return 0;
    }

    public double getInclinacao() {
        return inclinacao;
    }

    public double getSaturacaoSolo() {
        return saturacaoSolo;
    }


}
