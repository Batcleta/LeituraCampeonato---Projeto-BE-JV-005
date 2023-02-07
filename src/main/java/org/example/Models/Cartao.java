package org.example.Models;

public class Cartao {
    private String partidaId;
    private String rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private String numCamisa;
    private String posicao;
    private String minuto;

    public Cartao(String partidaId, String rodada, String clube, String cartao, String atleta, String numCamisa, String posicao, String minuto) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.numCamisa = numCamisa;
        this.posicao = posicao;
        this.minuto = minuto;
    }

    public String getPartidaId() {
        return partidaId;
    }

    public String getRodada() {
        return rodada;
    }

    public String getClube() {
        return clube;
    }

    public String getCartao() {
        return cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getNumCamisa() {
        return numCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getMinuto() {
        return minuto;
    }
}
