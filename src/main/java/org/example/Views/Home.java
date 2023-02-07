package org.example.Views;

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
//            db.buscarPartidas().forEach(partida -> {
//                System.out.println(partida.getData());
//            });

//            >> buscarEstatisticas rodando ok - busca todas as estatisticas
//            db.buscarEstatisticas().forEach(estatistica -> {
//                System.out.println(estatistica.getFaltas());
//            });

//            >> buscarGols rodando ok - busca todos os gols
//            db.buscarGols().forEach(gol -> {
//                System.out.println(gol.getAtleta());
//            });


        } while (executing);
    }
}
