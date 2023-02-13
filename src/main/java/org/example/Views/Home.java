package org.example.Views;

import org.example.Controller.*;
import org.example.Database.Database;
import org.example.Models.Cartao;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.List;

public class Home {
    public static void init() {
        Database db = Database.getInstance();
        List<Partida> partidas = db.buscarPartidas();
        List<Gol> gols = db.buscarGols();
        List<Cartao> cartoes = db.buscarCartoes();
        boolean executing;
        int option;

        do {
            executing = false;
            System.out.println();

            TimeDoAno.timeDoAno(2008, partidas);
            EstadoComMenosJogos.estadoComMenosJogos(2003, 2022, partidas);
            JogadorComMaisGols.jogadorComMaisGols(gols, "");
            JogadorComMaisGols.jogadorComMaisGols(gols, "Penalty");
            JogadorComMaisGols.jogadorComMaisGols(gols, "Gol Contra");
            JogadorComMaisCartoes.JogadorComMaisCartoes(cartoes, "Amarelo");
            JogadorComMaisCartoes.JogadorComMaisCartoes(cartoes, "Vermelho");
            PlacarDaPartidaComMaisGols.placarDaPartidaComMaisGols(db);

        } while (executing);
    }
}