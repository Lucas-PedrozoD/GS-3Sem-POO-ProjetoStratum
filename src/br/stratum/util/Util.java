package br.stratum.util;

import br.stratum.satelite.Satelite;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
public void menu(){
    int opcao = 1;
    String aux, aux1;
    int cont = 1;
    Satelite satelite = new Satelite();

    aux = """
            1. Cadastrar Região
            2. Cadastrar Equipamento a região
            3. Relatorio de Registros cadastrados
            4. Calcular Risco e fazer previsão de região
            5. Calcular desgaste de Equipamento
            6. Registrar Evento
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
                aux1 = """
                                Região a Cadastrar
                                1.Montanha
                                2.Floresta
                                3.Pantano
                                """;
                cont= parseInt(showInputDialog(aux1));
            }
        }
    }

}

}
