package br.stratum.equipamento;

public class EstacaoSensor extends Equipamento{
    private int leiturasRealizadas;

    public EstacaoSensor(int id, double horasUso, int leiturasRealizadas) {
        super(id, horasUso);
        this.leiturasRealizadas = leiturasRealizadas;
    }

    @Override
    public double calcularDesgaste() {
        double desgaste = horasUso * 0.3 + leiturasRealizadas * 0.01;
        if (desgaste > 100){
            desgaste = 100;
        }
        return desgaste;
    }
}
