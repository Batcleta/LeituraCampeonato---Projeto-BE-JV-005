package org.example.Controller;

import org.example.Database.Database;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlacarDaPartidaComMaisGols {

    public static void placarDaPartidaComMaisGols(Database db) {
        List<Gol> gols = db.buscarGols();

        if (gols.isEmpty()) {
            System.out.println("Não foram encontrados resultados");
            return;
        }

        Map<String, Map<String, Integer>> golsPorPartidaPorJogador = gols.stream()
                .filter(gol -> gol.getPartidaId() != null && !gol.getPartidaId().equalsIgnoreCase("-"))
                .filter(gol -> gol.getAtleta() != null && !gol.getAtleta().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Gol::getPartidaId,
                        Collectors.toMap(gol -> gol.getAtleta() + " - " + gol.getClube(),
                                gol -> 1, Integer::sum)));

        List<String> partidasComMaisGols = golsPorPartidaPorJogador.entrySet().stream()
                .map(entry -> {
                    Partida partida = db.buscarPartidaPorId(entry.getKey());
                    StringBuilder sb = new StringBuilder();
                    sb.append("Partida: " + entry.getKey() + "\nGols: " + entry.getValue().values().stream().mapToInt(Integer::intValue).sum() + "\nPlacar: " +
                            partida.getMandante() + " - " + partida.getMandantePlacar() + " X " +
                            partida.getVisitantePlacar() + " - " + partida.getVisitante() + "\n");
                    entry.getValue().forEach((jogador, gol) -> sb.append("Jogador: " + jogador + " | Gols: " + gol + "\n"));
                    return sb.toString();
                })
                .collect(Collectors.groupingBy(match -> {
                    int goals = match.chars().filter(c -> c == 'G').map(c -> 1).sum();
                    return goals;
                }))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(List.of());

        if (partidasComMaisGols.size() > 1) {
            System.out.println("\nHouveram " + partidasComMaisGols.size() + " Partidas empatadas em gols\n\n");
        } else {
            System.out.println("Partida vitoriosa\n");
        }

        partidasComMaisGols.forEach(System.out::println);
        System.out.println("\n\n");
    }
}
