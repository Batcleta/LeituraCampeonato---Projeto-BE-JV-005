package org.example.Models;

public class Partida {

    private String ID;
    private String rodada;
    private String data;
    private String hora;
    private String mandante;
    private String visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private String mandantePlacar;
    private String visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;


    public Partida(String ID, String rodada, String data, String hora, String mandante,
                   String visitante, String formacaoMandante, String formacaoVisitante,
                   String tecnicoMandante, String tecnicoVisitante, String vencedor, String arena,
                   String mandantePlacar, String visitantePlacar, String mandanteEstado, String visitanteEstado) {
        this.ID = ID;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacaoMandante = formacaoMandante;
        this.formacaoVisitante = formacaoVisitante;
        this.tecnicoMandante = tecnicoMandante;
        this.tecnicoVisitante = tecnicoVisitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.mandanteEstado = mandanteEstado;
        this.visitanteEstado = visitanteEstado;
    }

    public String getID() {
        return ID;
    }

    public String getRodada() {
        return rodada;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMandante() {
        return mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getFormacaoMandante() {
        return formacaoMandante;
    }

    public String getFormacaoVisitante() {
        return formacaoVisitante;
    }

    public String getTecnicoMandante() {
        return tecnicoMandante;
    }

    public String getTecnicoVisitante() {
        return tecnicoVisitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getArena() {
        return arena;
    }

    public String getMandantePlacar() {
        return mandantePlacar;
    }

    public String getVisitantePlacar() {
        return visitantePlacar;
    }

    public String getMandanteEstado() {
        return mandanteEstado;
    }

    public String getVisitanteEstado() {
        return visitanteEstado;
    }
}
