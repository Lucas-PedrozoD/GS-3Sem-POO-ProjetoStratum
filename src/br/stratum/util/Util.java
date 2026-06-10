package br.stratum.util;

import br.stratum.equipamento.Drone;
import br.stratum.equipamento.EstacaoSensor;
import br.stratum.estruturaMonitorada.BarragemRejeito;
import br.stratum.estruturaMonitorada.Cava;
import br.stratum.estruturaMonitorada.EstruturaMonitorada;
import br.stratum.evento.Evento;
import br.stratum.satelite.Satelite;
import br.stratum.equipamento.Equipamento;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
public void menu(){
    DecimalFormat df = new DecimalFormat("##,#00");
    int opcao = 1;
    String aux;
    Satelite satelite = new Satelite();

    aux = """
            1. Cadastrar Estrutura
            2. Cadastrar Equipamento a Estrutura
            3. Relatorio de Registros cadastrados
            4. Fazer previsão calcular risco de Estrutura
            5. Calcular desgaste de Equipamento de Estrutura
            6. Registrar Acontecimento
            7. Histórico de Eventos
            8. Calcular o IPO
            9. Exibir Relatorio Geral
            10. Carregar dados de exemplo
            0. Finalizar
            """;

    do {
        try{
            opcao = parseInt(showInputDialog(aux));
        }catch (NumberFormatException e){
            showMessageDialog(null, "A opção deve ser um"+
                    " numero inteiro\n");
        }
        switch (opcao){
            case (1) -> {

                String aux1 = """
                                Escolha a Estrutura para Cadastrar
                                1.Barragem Regeito
                                2.Cava
                                """;
                int opcao1 = parseInt(showInputDialog(aux1));
                if (opcao1 == 1){
                     aux1 = "Nome da Barragem Regeito ";
                    String nome = "Barragem ";
                    nome += showInputDialog(aux1);
                    aux1 = "Area da Barragem (em m²)";
                    double area =parseDouble (showInputDialog(aux1));
                    aux1 = "Tendencia Mensal exemplo: 1, -1 ou 0";
                    double tendenciaMensal = parseDouble(showInputDialog(aux1));
                    aux1 = " Deformação (0 - 100)";
                    int deformacao = parseInt(showInputDialog(aux1));
                    aux1 = " Saturação do Material de umidade(0 - 100)";
                    int saturacaoMaterial = parseInt(showInputDialog(aux1));
                    satelite.adicionarEstruturas(new BarragemRejeito(nome,area,tendenciaMensal,deformacao,saturacaoMaterial));
                }else if (opcao1 == 2){
                    aux1 = "Nome da Cava ";
                    String nome = "Cava ";
                    nome += showInputDialog(aux1);
                    aux1 = "Area da Cava (em m²)";
                    double area =parseDouble (showInputDialog(aux1));
                    aux1 = "Tendencia Mensal exemplo: 1, -1 ou 0";
                    double tendenciaMensal = parseDouble(showInputDialog(aux1));
                    aux1 = " Inclinação de Talude (0 - 100)";
                    double inclinacao = parseDouble(showInputDialog(aux1));
                    aux1 = " Fraturamento (0 - 100)";
                    double fraturamenento = parseDouble(showInputDialog(aux1));
                    satelite.adicionarEstruturas(new Cava(nome,area,tendenciaMensal, inclinacao, fraturamenento));
                }

            }
            case (2) ->{
                if (satelite.getListaEstruturas().isEmpty()){
                    showMessageDialog(null,"Não existem estruturas cadastradas. \n Cadastre uma estrutura primeiro");
                }
                else {
                    int indice ;
                    String lista = satelite.listarListaEstruturas();
                    indice = parseInt(showInputDialog(lista + "\n Escolha a Estrutura") );
                    indice --;
                    if(indice < 0 || indice >= satelite.getListaEstruturas().size()){
                        showMessageDialog(null, "Estrutura inválida!");
                        break;
                    }
                    int opcao1;

                    String aux1 = """
                                Escolha o Equipamento a Cadastrar a Estrutura
                                1. Drone
                                2. Estação Sensor
                                """;
                    opcao1 = parseInt(showInputDialog(aux1));
                    if (opcao1 == 1){
                        aux1 = "Horas de Uso ";
                        double horasUso =parseDouble (showInputDialog(aux1));
                        aux1 = "Distancia já percorrida ";
                        double distanciaPercorrida = parseDouble(showInputDialog(aux1));
                        satelite.adicionarEquipamentos(indice, new Drone(horasUso, distanciaPercorrida));

                    }
                    else if (opcao1 == 2){
                        aux1 = "Horas de Uso ";
                        double horasUso =parseDouble (showInputDialog(aux1));
                        aux1 = "Número de Leituras";
                        int leiturasRealizadas = parseInt(showInputDialog(aux1));
                        satelite.adicionarEquipamentos(indice, new EstacaoSensor(horasUso, leiturasRealizadas));
                    }
                }

            }
            case (3)->{
                showMessageDialog(null,satelite.relatorioRegistros());
            }

            case (4) -> {
                if (satelite.getListaEstruturas().isEmpty()){
                    showMessageDialog(null,"Não existem estruturas cadastradas. \n Cadastre uma estrutura primeiro");
                }
                else {
                    int indice;
                    String lista = satelite.listarListaEstruturas();
                    indice = parseInt(showInputDialog(lista + "\n O risco de Qual estrutura vai ser calculado ?"));
                    indice--;
                    if (indice < 0 || indice >= satelite.getListaEstruturas().size()) {
                        showMessageDialog(null, "Estrutura inválida!");
                        break;
                    }
                    int meses;
                    meses = parseInt(showInputDialog("Quantos meses deseja projetar ?"));
                    if(meses <= 0){
                        showMessageDialog(null,
                                "Informe uma quantidade de meses válida.");
                        break;
                    }

                    EstruturaMonitorada estrutura = satelite.getListaEstruturas().get(indice);
                    double riscoAtual = estrutura.calcularRisco();
                    double riscoProjetado = estrutura.projetarRisco(meses);

                    showMessageDialog(null, "Estrutura: " + estrutura.getNome() +
                                    "\n\nRisco Atual: " + df.format(riscoAtual) +
                                    "\nRisco Projetado para " + meses + " meses: "
                                    + df.format(riscoProjetado)
                    );


                }
            }
            case (5) -> {
                if (satelite.getListaEstruturas().isEmpty()) {
                    showMessageDialog(null, "Não existem estruturas cadastradas.\nCadastre uma estrutura primeiro.");
                }
                else {
                    int indice;
                    String lista = satelite.listarListaEstruturas();

                    indice = parseInt(showInputDialog(lista + "\nEscolha a estrutura a ter o calculo de desgaste:"));
                    indice--;

                    if (indice < 0 || indice >= satelite.getListaEstruturas().size())
                    {showMessageDialog(null, "Estrutura inválida!");
                        break;
                    }
                    EstruturaMonitorada estrutura = satelite.getListaEstruturas().get(indice);

                    if (estrutura.getEquipamentos().isEmpty()) {
                        showMessageDialog(null, "Não existem equipamentos cadastrados nesta estrutura.");
                        break;
                    }

                    String listaEquipamentos = "";

                    for (int i = 0; i < estrutura.getEquipamentos().size(); i++) {
                        listaEquipamentos += (i + 1) + " - " + estrutura.getEquipamentos().get(i) + "\n";
                    }

                    int indiceEquipamento = parseInt(showInputDialog(listaEquipamentos + "\nEscolha o equipamento:"));
                    indiceEquipamento--;
                    if (indiceEquipamento < 0 || indiceEquipamento >= estrutura.getEquipamentos().size()) {
                        showMessageDialog(null, "Equipamento inválido!");
                        break;
                    }

                    Equipamento equipamento = estrutura.getEquipamentos().get(indiceEquipamento);

                    double desgaste = equipamento.calcularDesgaste();

                    showMessageDialog(null, "Equipamento: " + equipamento + "\nDesgaste: " + df.format(desgaste) + "%");
                }


            }
            case (6) -> {
                String descricao = showInputDialog("Descrição do acontecimento:");
                int gravidade;

                do {
                    gravidade = parseInt(
                            showInputDialog("Gravidade do evento (1 a 10):")
                    );

                    if (gravidade < 1 || gravidade > 10) {
                        showMessageDialog(null, "A gravidade deve estar entre 1 e 10.");
                    }

                } while (gravidade < 1 || gravidade > 10);


                Evento evento = new Evento(descricao, gravidade, LocalDate.now(), LocalTime.now());

                satelite.adicionarEvento(evento);

                showMessageDialog(null, "Evento registrado com sucesso!");
            }
            case (7) -> {
                showMessageDialog(null, satelite.listarEventos());
            }
            case (8) -> {
                double ipo = satelite.calcularIPO();
                String classificacao;

                if (ipo >= 70) {
                    classificacao = "VERDE - Sistema Operacional";
                }
                else if (ipo >= 40) {
                    classificacao = "AMARELO - Atenção Necessária";
                }
                else {
                    classificacao = "VERMELHO - Intervenção Imediata";
                }
                showMessageDialog(null, "ÍNDICE DE PRONTIDÃO OPERACIONAL\n\n" + "IPO: " + df.format(ipo) + "\nClassificação: " + classificacao);
            }
            case (9) -> {

                double ipo = satelite.calcularIPO();

                String classificacao;

                if (ipo >= 70) {
                    classificacao = "VERDE";
                }
                else if (ipo >= 40) {
                    classificacao = "AMARELO";
                }
                else {
                    classificacao = "VERMELHO";
                }

                showMessageDialog(null,
                        satelite.relatorioRegistros() + "\n====================\n" + "IPO: " + df.format(ipo) + "\nClassificação: " + classificacao);
            }
            case (10) -> {

                satelite.adicionarEstruturas(
                        new BarragemRejeito("Barragem Exemplo", 5000, 2, 30, 40)
                );

                satelite.adicionarEstruturas(
                        new Cava("Cava Exemplo", 3000, -1, 45, 20)
                );

                showMessageDialog(null, "Dados de exemplo carregados com sucesso!");
            }




        }
    }while (opcao != 0);

}

public void cadastrarEstrutura(){

}

}
