package br.stratum.regiao;

public abstract class Regiao {
    protected String nome;
    protected double area;
    protected double tendenciaMensal;

    public Regiao(String nome, double area, double tendencia) {
        this.nome = nome;
        this.area = area;
        this.tendenciaMensal = tendencia;
    }

    public abstract double calcularRisco();

    public double getTendenciaMensal() {
        return tendenciaMensal;
    }

    public void setTendenciaMensal(double tendenciaMensal) {
        this.tendenciaMensal = tendenciaMensal;
    }

    public String getNome() {
        return nome;
    }

    public double getArea() {
        return area;
    }
}
