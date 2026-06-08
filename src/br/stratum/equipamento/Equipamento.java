package br.stratum.equipamento;

public abstract class Equipamento {
    protected int id;
    protected double horasUso;

    public Equipamento(int id, double horasUso) {
        this.id = id;
        this.horasUso = horasUso;
    }

    public abstract double calcularDesgaste();

}
