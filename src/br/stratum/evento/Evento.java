package br.stratum.evento;

public class Evento {
    private String descricao;
    private int gravidade;
    private String quando;


    public Evento(String descricao, int gravidade, String quando) {
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.quando = quando;
    }


}
