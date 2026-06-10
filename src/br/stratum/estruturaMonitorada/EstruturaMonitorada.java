package br.stratum.estruturaMonitorada;

import br.stratum.equipamento.Equipamento;
import br.stratum.interfaces.Projecao;

import java.util.ArrayList;

public abstract class EstruturaMonitorada implements Projecao {

    protected String nome;
    protected double area;
    protected double tendenciaMensal;
    protected ArrayList<Equipamento> equipamentos;

    public EstruturaMonitorada(String nome,
                               double area,
                               double tendenciaMensal) {

        this.nome = nome;
        this.area = area;
        this.tendenciaMensal = tendenciaMensal;
        this.equipamentos = new ArrayList<>();
    }

    public abstract double calcularRisco();

    @Override
    public double projetarRisco(int meses) {

        double risco = calcularRisco() + (tendenciaMensal * meses);

        if (risco < 0) {
            risco = 0;
        }

        if (risco > 100) {
            risco = 100;
        }

        return risco;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public String getNome() {
        return nome;
    }

    public double getArea() {
        return area;
    }

    public double getTendenciaMensal() {
        return tendenciaMensal;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }
}