package org.example.Controller;

import org.example.Database.Database;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlacarDaPartidaComMaisGols {

    public static void placarDaPartidaComMaisGols(Database db) {
        List<Gol> gols = db.buscarGols();

        if (gols.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Map<String, Integer>> golsPorPartidaPorJogador = new HashMap<>();

//        for (Gol gol : gols) {
//            String partida = gol.getPartidaId();
//            String jogador = gol.getAtleta();
//            if (partida != null && !partida.equalsIgnoreCase("-") && jogador != null && !jogador.equalsIgnoreCase("-")) {
//                golsPorPartidaPorJogador.putIfAbsent(partida, new HashMap<>());
//                golsPorPartidaPorJogador.get(partida).put(jogador, golsPorPartidaPorJogador.get(partida).getOrDefault(jogador, 0) + 1);
//            }
//        }

        for (Gol gol : gols) {
            String partida = gol.getPartidaId();
            String jogador = gol.getAtleta();
            if (partida != null && !partida.equalsIgnoreCase("-") && jogador != null && !jogador.equalsIgnoreCase("-")) {
                golsPorPartidaPorJogador.computeIfAbsent(partida, k -> new HashMap<>());
                golsPorPartidaPorJogador.get(partida).compute(jogador, (key, value) -> value == null ? 1 : value + 1);
            }
        }

        int maxGoals = 0;
        List<String> pioresEstados = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> golsPorJogador : golsPorPartidaPorJogador.entrySet()) {
            int golsNaPartida = golsPorJogador.getValue().values().stream().mapToInt(Integer::intValue).sum();
            if (golsNaPartida > maxGoals) {
                maxGoals = golsNaPartida;
                pioresEstados.clear();

                Partida partida = db.buscarPartidaPorId(golsPorJogador.getKey());
                Map<String, Integer> golsPorJogadorNaPartida = golsPorJogador.getValue();

                StringBuilder sb = new StringBuilder();
                sb.append("Partida: " + golsPorJogador.getKey() + "\nGols: " + maxGoals + "\nPlacar: " +
                        partida.getMandantePlacar() + " - " + partida.getMandante() + " X " +
                        partida.getVisitantePlacar() + " - " + partida.getVisitante() + "\n");
                for (Map.Entry<String, Integer> golPorJogador : golsPorJogadorNaPartida.entrySet()) {
                    sb.append("Jogador: " + golPorJogador.getKey() + " | Gols: " + golPorJogador.getValue() + "\n");
                }

                pioresEstados.add(sb.toString());
            } else if (golsNaPartida == maxGoals) {

                Partida partida = db.buscarPartidaPorId(golsPorJogador.getKey());
                Map<String, Integer> golsPorJogadorInMatch = golsPorJogador.getValue();

                StringBuilder sb = new StringBuilder();
                sb.append("Partida: " + golsPorJogador.getKey() + " | Gols: " + maxGoals + "\nPlacar: " +
                        partida.getMandantePlacar() + " - " + partida.getMandante() + " X " +
                        partida.getVisitantePlacar() + " - " + partida.getVisitante() + "\n");
                for (Map.Entry<String, Integer> golPorJogador : golsPorJogadorInMatch.entrySet()) {
                    sb.append(" Jogador: " + golPorJogador.getKey() + " | Gols: " + golPorJogador.getValue() + "\n");
                }

                pioresEstados.add(sb.toString());
            }
        }

        if (pioresEstados.size() > 1) {
            System.out.print("\nFORAM " + pioresEstados.size() + " TIMES EMPATADOS EM MAIS GOLS\n\n");
        } else {
            System.out.print("TIME VITORIOSO\n");
        }

        pioresEstados.forEach(System.out::println);

        System.out.print("\n\n");
    }

}
