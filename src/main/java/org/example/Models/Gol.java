package org.example.Models;

public class Gol {
    private String partidaId;
    private String rodada;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipoDeGol;

    public Gol(String partidaId, String rodada, String clube, String atleta, String minuto, String tipoDeGol) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipoDeGol = tipoDeGol;
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

    public String getAtleta() {
        return atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public String getTipoDeGol() {
        return tipoDeGol;
    }
}
