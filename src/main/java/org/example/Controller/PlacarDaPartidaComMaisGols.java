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

        Map<String, Integer> golsPorPartida = new HashMap<>();

        for (
                Gol gol : gols) {
            String partida = gol.getPartidaId();
            if (partida != null && !partida.equalsIgnoreCase("-")) {
                golsPorPartida.put(partida, golsPorPartida.getOrDefault(partida, 0) + 1);
            }
        }

        int maxGoals = 0;
        List<String> pioresEstados = new ArrayList<>();

        for (
                Map.Entry<String, Integer> gol : golsPorPartida.entrySet()) {
            if (gol.getValue() > maxGoals) {
                maxGoals = gol.getValue();
                pioresEstados.clear();

                Partida partida = db.buscarPartidaPorId(gol.getKey());

                pioresEstados.add("Partida: " + gol.getKey() + ", com: " + gol.getValue() + " com o placar final de: " +
                        partida.getMandantePlacar() + " - " + partida.getMandante() + " X " +
                        partida.getVisitantePlacar() + " - " + partida.getVisitante());
            } else if (gol.getValue() == maxGoals) {

                Partida partida = db.buscarPartidaPorId(gol.getKey());

                pioresEstados.add("Partida: " + gol.getKey() + ", com: " + gol.getValue() + " com o placar final de: " +
                        partida.getMandantePlacar() + " - " + partida.getMandante() + " X " +
                        partida.getVisitantePlacar() + " - " + partida.getVisitante());
            }
        }

        if (pioresEstados.size() > 1) {
            System.out.print("\nFORAM " + pioresEstados.size() + " TIMES VITORIOSOS\n\n");
        } else {
            System.out.print("TIME VITORIOSO\n");
        }

        pioresEstados.forEach(System.out::println);

        System.out.print("\n\n");
    }

}
