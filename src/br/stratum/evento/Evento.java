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

    @Override
    public String toString() {
        return quandoDia +
                " " +
                quandoHora +
                " | Gravidade: " +
                gravidade +
                " | " +
                descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getGravidade() {
        return gravidade;
    }

    public LocalDate getQuandoDia() {
        return quandoDia;
    }

    public LocalTime getQuandoHora() {
        return quandoHora;
    }
}
