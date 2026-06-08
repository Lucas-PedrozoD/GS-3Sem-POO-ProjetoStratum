package br.stratum.regiao;

public class Pantano extends Regiao{

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
}
