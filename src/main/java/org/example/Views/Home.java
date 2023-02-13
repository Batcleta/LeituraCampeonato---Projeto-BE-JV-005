package org.example.Views;

import org.example.Controller.*;
import org.example.Database.Database;
import org.example.Models.Cartao;
import org.example.Models.Gol;
import org.example.Models.Partida;
import org.example.Utils.MenuCreator;

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

            option = MenuCreator.exec("DIGITE A OPÇÃO DESEJADA:", "SAIR",
                    "Time que mais venceu jogos no ano 2008",
                    "Estado que teve menos jogos dentro do período 2003 e 2022",
                    "jogador que mais fez gols",
                    "jogador que mais fez gols de pênaltis",
                    "jogador que mais fez gols contras",
                    "jogador que mais recebeu cartões amarelos",
                    "jogador que mais recebeu cartões vermelhos",
                    "placar da partida com mais gols"
            );

            System.out.println();

            switch (option) {
                case 1 -> TimeDoAno.timeDoAno(2008, partidas);
                case 2 -> EstadoComMenosJogos.estadoComMenosJogos(2003, 2022, partidas);
                case 3 -> JogadorComMaisGols.jogadorComMaisGols(gols, "");
                case 4 -> JogadorComMaisGols.jogadorComMaisGols(gols, "Penalty");
                case 5 -> JogadorComMaisGols.jogadorComMaisGols(gols, "Gol Contra");
                case 6 -> JogadorComMaisCartoes.JogadorComMaisCartoes(cartoes, "Amarelo");
                case 7 -> JogadorComMaisCartoes.JogadorComMaisCartoes(cartoes, "Vermelho");
                case 8 -> PlacarDaPartidaComMaisGols.placarDaPartidaComMaisGols(db);
                case 0 -> System.out.println("ENCERRANDO APLICAÇÃO");
                default -> System.out.println("OPÇÃO INVÁLIDA");
            }

        } while (executing);
    }
}