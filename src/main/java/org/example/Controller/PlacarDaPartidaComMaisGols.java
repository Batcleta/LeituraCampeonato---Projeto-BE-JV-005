package org.example.Controller;

import org.example.Database.Database;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlacarDaPartidaComMaisGols {

    public static void placarDaPartidaComMaisGols(Database db) {
        List<Gol> gols = db.buscarGols();

        if (gols.isEmpty()) {
            System.out.println("No results found");
            return;
        }

        Map<String, Map<String, Integer>> golsPorPartidaPorJogador = gols.stream()
                .filter(gol -> gol.getPartidaId() != null && !gol.getPartidaId().equalsIgnoreCase("-"))
                .filter(gol -> gol.getAtleta() != null && !gol.getAtleta().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Gol::getPartidaId,
                        Collectors.toMap(gol -> gol.getAtleta() + " - " + gol.getClube(),
                                gol -> 1, Integer::sum)));

        List<String> PartidasComMaisGols = golsPorPartidaPorJogador.entrySet().stream()
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

        if (PartidasComMaisGols.size() > 1) {
            System.out.println("\nExistem " + PartidasComMaisGols.size() + " Partidas empatadas \n\n");
        } else {
            System.out.println("Partida com mais gols\n");
        }

        PartidasComMaisGols.forEach(System.out::println);

        System.out.println("\n\n");
    }
}
