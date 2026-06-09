package br.stratum.evento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String descricao;
    private int gravidade;
    private LocalDate quandoDia;
    private LocalTime quandoHora;

    public Evento(String descricao, int gravidade, LocalDate quandoDia, LocalTime quandoHora) {
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.quandoDia = quandoDia;
        this.quandoHora = quandoHora;
    }


}
