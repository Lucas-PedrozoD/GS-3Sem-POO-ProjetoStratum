package br.stratum.regiao;

public class Floresta extends Regiao{

    private double securaVegetacao;
    private double temperatura;

    public Floresta(String nome, double area, double tendencia, double secura, double densidadeVegetacao) {
        super(nome, area, tendencia);
        this.securaVegetacao = secura;
        this.temperatura = densidadeVegetacao;
    }

    @Override
    public double calcularRisco() {
        double tempNormalizada = (temperatura / 50) * 100;
        if (tempNormalizada > 100){
            tempNormalizada = 100;
        }
        double risco = securaVegetacao * 0.6 + tempNormalizada * 0.4;
        if (risco > 100){
            risco = 100;
        }

        return risco;
    }
}
