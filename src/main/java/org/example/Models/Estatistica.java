package org.example.Models;

public class Estatistica {

    private String partidaId;
    private String rodada;
    private String clube;
    private String chutes;
    private String chutesNoAlvo;
    private String posseDeBola;
    private String passes;
    private String precisaoDePasses;
    private String faltas;
    private String cartaoAmarelo;
    private String cartaoVermelho;
    private String impedimentos;
    private String escanteios;

    public Estatistica(String partidaId, String rodada, String clube, String chutes, String chutesNoAlvo, String posseDeBola, String passes, String precisaoDePasses, String faltas, String cartaoAmarelo, String cartaoVermelho, String impedimentos, String escanteios) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutesNoAlvo = chutesNoAlvo;
        this.posseDeBola = posseDeBola;
        this.passes = passes;
        this.precisaoDePasses = precisaoDePasses;
        this.faltas = faltas;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
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

    public String getChutes() {
        return chutes;
    }

    public String getChutesNoAlvo() {
        return chutesNoAlvo;
    }

    public String getPosseDeBola() {
        return posseDeBola;
    }

    public String getPasses() {
        return passes;
    }

    public String getPrecisaoDePasses() {
        return precisaoDePasses;
    }

    public String getFaltas() {
        return faltas;
    }

    public String getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public String getCartaoVermelho() {
        return cartaoVermelho;
    }

    public String getImpedimentos() {
        return impedimentos;
    }

    public String getEscanteios() {
        return escanteios;
    }
}
