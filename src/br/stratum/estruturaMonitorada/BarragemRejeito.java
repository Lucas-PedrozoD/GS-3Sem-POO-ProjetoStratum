package br.stratum.estruturaMonitorada;

import br.stratum.equipamento.Equipamento;

public class BarragemRejeito extends EstruturaMonitorada{
    private int deformacao;
    private int saturacaoDoMaterial;

    public BarragemRejeito(String nome, double area, double tendenciaMensal, int deformacao, int saturacaoDoMaterial) {
        super(nome, area, tendenciaMensal);
        this.deformacao = deformacao;
        this.saturacaoDoMaterial = saturacaoDoMaterial;
    }

    @Override
    public double calcularRisco() {
        double risco = deformacao * 0.6 + saturacaoDoMaterial * 0.4;
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
