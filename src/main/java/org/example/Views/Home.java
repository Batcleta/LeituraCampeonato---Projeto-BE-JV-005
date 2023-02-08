package org.example.Views;

import Database.Database;
import org.example.Models.Partida;
import org.example.Utils.DateConversor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


//            timeDoAno(2008, db.buscarPartidas());
            estadoComMenosJogos(2003, 2022, db.buscarPartidas());

        } while (executing);
    }

    public static void timeDoAno(int ano, List<Partida> partidas) {
        List<Partida> partidasDoAno = partidas.stream().filter(partida -> partida.getData().getYear() == ano).collect(Collectors.toList());

        if (partidasDoAno.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
        }
        Map<String, Integer> vitoriasPorTime = new HashMap<>();

        for (Partida partida : partidasDoAno) {
            String vencedor = partida.getVencedor();
            if (vencedor != null && !vencedor.equalsIgnoreCase("-")) {
                vitoriasPorTime.put(vencedor, vitoriasPorTime.getOrDefault(vencedor, 0) + 1);
            }
        }

        int maxWins = 0;
        List<String> melhoresTimes = new ArrayList<>();

        for (Map.Entry<String, Integer> time : vitoriasPorTime.entrySet()) {
            if (time.getValue() > maxWins) {
                maxWins = time.getValue();
                melhoresTimes.clear();
                melhoresTimes.add("Time: " + time.getKey() + ", com: " + time.getValue() + " vitórias.");
            } else if (time.getValue() == maxWins) {
                melhoresTimes.add("Time: " + time.getKey() + ", com: " + time.getValue() + " vitórias.");
            }
        }

        if (melhoresTimes.size() > 1) {
            System.out.print("\nFORAM " + melhoresTimes.size() + " TIMES VITORIOSOS\n\n");
        } else {
            System.out.print("TIME VITORIOSO\n");
        }

        melhoresTimes.forEach(System.out::println);

        System.out.print("\n\n");
    }

    public static void estadoComMenosJogos(int prtiodoInicial, int periodoFinal, List<Partida> partidas) {
        List<Partida> partidasDoAno = partidas.stream().filter(partida -> {
            int year = partida.getData().getYear();
            return year >= prtiodoInicial && year <= periodoFinal;
        }).collect(Collectors.toList());

        if (partidasDoAno.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
        }
        Map<String, Integer> partidasPorEstado = new HashMap<>();

        for (Partida partida : partidasDoAno) {
            String estado = partida.getMandanteEstado();
            if (estado != null && !estado.equalsIgnoreCase("-")) {
                partidasPorEstado.put(estado, partidasPorEstado.getOrDefault(estado, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : partidasPorEstado.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    public static void jogadorComMaisGols() {

    }

    public static void jogadorComMaisGolsDePênalti() {

    }

    public static void jogadorComMaisGolsContras() {

    }

    public static void jogadorComMaisCartoesAmarelos() {

    }

    public static void jogadorComMaisCartoesVermelhos() {

    }

    public static void placarDaPartidaComMaisGols() {

    }
}
