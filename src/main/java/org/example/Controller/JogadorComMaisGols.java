package org.example.Controller;
import org.example.Models.Gol;

import java.util.*;
import java.util.stream.Collectors;

public class JogadorComMaisGols {

    public static void jogadorComMaisGols(List<Gol> gols, String tipo) {
        List<Gol> golsPorTipo = gols;

        if (!tipo.equals("")) {
            golsPorTipo = gols.stream().filter(gol -> gol.getTipoDeGol().equalsIgnoreCase(tipo)).collect(Collectors.toList());
        }

        if (golsPorTipo.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Long> golsPorJogadores = golsPorTipo.stream()
                .filter(gol -> gol.getAtleta() != null && !gol.getAtleta().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        String jogadorComMaisGols = golsPorJogadores.entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.max(golsPorJogadores.values()))
                .map(entry -> "Jogador: " + entry.getKey() + ", com: " + entry.getValue() + " gols.\n")
                .collect(Collectors.joining(""));

        System.out.println("=== Jogadores com mais gols ===\n" + jogadorComMaisGols);
        System.out.print("\n\n");

    }
}