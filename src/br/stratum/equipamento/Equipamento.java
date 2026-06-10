package br.stratum.equipamento;

import br.stratum.interfaces.Desgastavel;

public abstract class Equipamento implements Desgastavel {

    protected static int proxId = 1000;
    protected int id;
    protected double horasUso;

    public Equipamento(double horasUso) {
        this.id = proxId++;
        this.horasUso = horasUso;
    }

    @Override
    public abstract double calcularDesgaste();

    @Override
    public abstract String toString();

    public static int getProxId() {
        return proxId;
    }

    public int getId() {
        return id;
    }

    public double getHorasUso() {
        return horasUso;
    }
}
