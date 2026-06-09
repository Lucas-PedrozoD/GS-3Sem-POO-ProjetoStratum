package br.stratum.regiao;

import br.stratum.interfaces.Monitoramento;
import br.stratum.interfaces.Projecao;

public class Pantano extends Regiao implements Monitoramento, Projecao {

    private double nivelDeAgua;
    private double chuvaRecente;

    public Pantano(String nome, double area, double tendencia, double nivelDeAgua, double instabilidadeSolo) {
        super(nome, area, tendencia);
        this.nivelDeAgua = nivelDeAgua;
        this.chuvaRecente = instabilidadeSolo;
    }

    @Override
    public double calcularRisco() {
        double risco = nivelDeAgua * 0.6 + chuvaRecente * 0.4;
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
