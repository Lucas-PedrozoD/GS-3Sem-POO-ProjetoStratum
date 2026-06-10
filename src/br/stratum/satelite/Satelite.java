package br.stratum.satelite;

import br.stratum.equipamento.Equipamento;
import br.stratum.evento.Evento;
import br.stratum.estruturaMonitorada.EstruturaMonitorada;

import java.util.ArrayList;

public class Satelite {

    private ArrayList<EstruturaMonitorada> listaEstruturas = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();

    public double calcularIPO() {

        double fatorEstrutura = calcularFatorEstrutura();
        double fatorEquipamento = calcularFatorEquipamento();
        double fatorEventos = calcularFatorEventos();

        return fatorEstrutura * 0.5 + fatorEquipamento * 0.3 + fatorEventos * 0.2;
    }

    private double calcularFatorEstrutura() {

        if (listaEstruturas.isEmpty()) {
            return 100;
        }

        double soma = 0;

        for (EstruturaMonitorada estrutura : listaEstruturas) {
            soma += estrutura.calcularRisco();
        }

        double riscoMedio = soma / listaEstruturas.size();
        return Math.max(0, 100 - riscoMedio);
    }

    private double calcularFatorEquipamento() {

        double soma = 0;
        int quantidade = 0;

        for (EstruturaMonitorada estrutura : listaEstruturas) {

            for (Equipamento equipamento : estrutura.getEquipamentos()) {soma += equipamento.calcularDesgaste();quantidade++;
            }
        }

        if (quantidade == 0) {
            return 100;
        }

        double desgasteMedio = soma / quantidade;

        return Math.max(0, 100 - desgasteMedio);
    }

    private double calcularFatorEventos() {

        if (eventos.isEmpty()) {
            return 100;
        }

        double soma = 0;

        for (Evento evento : eventos) {
            soma += evento.getGravidade();
        }

        double gravidadeMedia = soma / eventos.size();

        return Math.max(0, 100 - (gravidadeMedia * 10));
    }

    public void adicionarEstruturas(EstruturaMonitorada estrutura) {
        listaEstruturas.add(estrutura);
    }

    public void adicionarEquipamentos(int indiceEstrutura, Equipamento equipamento) {
        listaEstruturas.get(indiceEstrutura).adicionarEquipamento(equipamento);
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public String listarEventos() {

        if (eventos.isEmpty()) {
            return "Nenhum evento registrado.";
        }

        String aux = "";

        for (Evento evento : eventos) {
            aux += evento + "\n";
            aux += "-----------------------------\n";
        }

        return aux;
    }

    public String listarListaEstruturas() {

        String aux = "";

        for (int i = 0; i < listaEstruturas.size(); i++) {
            aux += (i + 1) + " - " + listaEstruturas.get(i).getNome() + "\n";
        }

        return aux;
    }

    public String relatorioRegistros() {

        if (listaEstruturas.isEmpty()) {
            return "Nenhuma estrutura cadastrada.";
        }

        String aux = "";

        for (EstruturaMonitorada estrutura : listaEstruturas) {

            aux += "=================================\n";
            aux += "Estrutura: " + estrutura.getNome() + "\n";
            aux += "Área: " + estrutura.getArea() + " m²\n";
            aux += "Tendência Mensal: " + estrutura.getTendenciaMensal() + "\n";

            if (estrutura.getEquipamentos().isEmpty()) {

                aux += "Equipamentos: Nenhum equipamento cadastrado\n";

            } else {

                aux += "Equipamentos:\n";

                for (Equipamento equipamento : estrutura.getEquipamentos()) {
                    aux += equipamento + "\n";
                }
            }

            aux += "\n";
        }

        return aux;
    }

    public ArrayList<EstruturaMonitorada> getListaEstruturas() {
        return listaEstruturas;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}