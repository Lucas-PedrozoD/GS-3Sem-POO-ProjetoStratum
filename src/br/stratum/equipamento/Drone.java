package br.stratum.equipamento;

public class Drone extends Equipamento{
    private double distanciaPercorrida;

    public Drone(int id, double horasUso, double distanciaPercorrida) {
        super(id, horasUso);
        this.distanciaPercorrida = distanciaPercorrida;
    }

    @Override
    public double calcularDesgaste() {
        double desgaste = horasUso * 0.5 + distanciaPercorrida * 0.05;
        if (desgaste > 100){
            desgaste = 100;
        }
        return desgaste ;
    }
}
