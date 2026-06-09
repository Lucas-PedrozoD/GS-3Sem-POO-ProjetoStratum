package br.stratum.regiao;

import br.stratum.interfaces.Monitoramento;
import br.stratum.interfaces.Projecao;

public class Floresta extends Regiao implements Monitoramento, Projecao {

    private double securaVegetacao;
    private double temperatura;

    public Floresta(String nome, double area, double tendencia, double secura, double densidadeVegetacao) {
        super(nome, area, tendencia);
        this.securaVegetacao = secura;
        this.temperatura = densidadeVegetacao;
    }

    @Override
    public double calcularRisco() {
        double tempNormalizada = (temperatura / 50) * 100;
        if (tempNormalizada > 100){
            tempNormalizada = 100;
        }
        double risco = securaVegetacao * 0.6 + tempNormalizada * 0.4;
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
}
