package org.example.Views;

import org.example.Controller.EstadoComMenosJogos;
import org.example.Controller.JogadorComMaisCartoes;
import org.example.Controller.JogadorComMaisGols;
import org.example.Controller.TimeDoAno;
import org.example.Database.Database;

public class Home {

    public static void init() {
        Database db = Database.getInstance();
        boolean executing;
        int option;

        do {
            executing = false;
            System.out.println("Chegou até aqui com sucesso!");

//            >> buscarCartoes rodando ok - busca todos os cartões
//            db.buscarCartoes().forEach(cartao -> {
//                System.out.println(cartao.getCartao());
//            });

//            >> buscarPartidas rodando ok - busca todos as partidas
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            db.buscarPartidas().forEach(partida -> {
//                System.out.println(partida.getID());
//                System.out.println(partida.getData().format(formatter) + " - " + partida.getHora());
//            });

//            >> buscarEstatisticas rodando ok - busca todas as estatisticas
//            db.buscarEstatisticas().forEach(estatistica -> {
//                System.out.println(estatistica.getFaltas());
//            });

//            >> buscarGols rodando ok - busca todos os gols
//            db.buscarGols().forEach(gol -> {
//                System.out.println(gol.getAtleta());
//            });

            //TESTE - Check the team who won more matches in 2008

            System.out.println();

            TimeDoAno.timeDoAno(2008, db.buscarPartidas());
            EstadoComMenosJogos.estadoComMenosJogos(2003, 2022, db.buscarPartidas());
            JogadorComMaisGols.jogadorComMaisGols(db.buscarGols(), "");
            JogadorComMaisGols.jogadorComMaisGols(db.buscarGols(), "Penalty");
            JogadorComMaisGols.jogadorComMaisGols(db.buscarGols(), "Gol Contra");
            JogadorComMaisCartoes.JogadorComMaisCartoes(db.buscarCartoes(), "Amarelo");
            JogadorComMaisCartoes.JogadorComMaisCartoes(db.buscarCartoes(), "Vermelho");

        } while (executing);
    }

}
