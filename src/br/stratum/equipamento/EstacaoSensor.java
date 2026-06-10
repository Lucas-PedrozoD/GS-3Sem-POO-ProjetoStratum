package br.stratum.equipamento;

public class EstacaoSensor extends Equipamento {

    private int leiturasRealizadas;

    public EstacaoSensor(double horasUso, int leiturasRealizadas) {
        super(horasUso);
        this.leiturasRealizadas = leiturasRealizadas;
    }

    @Override
    public double calcularDesgaste() {

        double desgaste =
                getHorasUso() * 0.3 +
                        leiturasRealizadas * 0.01;

        if (desgaste > 100) {
            desgaste = 100;
        }

        return desgaste;
    }

    @Override
    public String toString() {
        return "Estação Sensor - ID: " + getId();
    }

    public int getLeiturasRealizadas() {
        return leiturasRealizadas;
    }
}
