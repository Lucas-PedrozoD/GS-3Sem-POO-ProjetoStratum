package br.stratum.equipamento;

public class Drone extends Equipamento {

    private double distanciaPercorrida;

    public Drone(double horasUso, double distanciaPercorrida) {
        super(horasUso);
        this.distanciaPercorrida = distanciaPercorrida;
    }

    @Override
    public double calcularDesgaste() {

        double desgaste =
                getHorasUso() * 0.5 +
                        distanciaPercorrida * 0.05;

        if (desgaste > 100) {
            desgaste = 100;
        }

        return desgaste;
    }

    @Override
    public String toString() {
        return "Drone - ID: " + getId();
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }
}