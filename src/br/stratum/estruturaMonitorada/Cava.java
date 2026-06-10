package br.stratum.estruturaMonitorada;

import br.stratum.equipamento.Equipamento;

public class Cava extends EstruturaMonitorada {
    private double inclinacaoTalude;
    private double fraturamento;

    public Cava(String nome, double area, double tendenciaMensal, double inclinacaoTalude, double fraturamento) {
        super(nome, area, tendenciaMensal);
        this.inclinacaoTalude = inclinacaoTalude;
        this.fraturamento = fraturamento;
    }

    @Override
    public double calcularRisco() {
        double risco = inclinacaoTalude /90  * 60 + fraturamento * 0.4;
        if (risco > 100){
            risco = 100;
        }
        return risco;
    }

    @Override
    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }
}
