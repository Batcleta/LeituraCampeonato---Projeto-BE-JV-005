package org.example.Controller;

import org.example.Models.Cartao;
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

//        Map<String, Integer> golsPorJogadores = new HashMap<>();
//
//        for (Gol gol : golsPorTipo) {
//            String jogador = gol.getAtleta();
//            if (jogador != null && !jogador.equalsIgnoreCase("-")) {
//                golsPorJogadores.put(jogador, golsPorJogadores.getOrDefault(jogador, 0) + 1);
//            }
//        }
//
//        int maxGoals = 0;
//        List<String> melhoresJogadores = new ArrayList<>();
//
//        for (Map.Entry<String, Integer> jogador : golsPorJogadores.entrySet()) {
//            if (jogador.getValue() > maxGoals) {
//                maxGoals = jogador.getValue();
//                melhoresJogadores.clear();
//                melhoresJogadores.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " gols.");
//            } else if (jogador.getValue() == maxGoals) {
//                melhoresJogadores.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " gols.");
//            }
//        }
//
//        if (melhoresJogadores.size() > 1) {
//            System.out.print("### " + melhoresJogadores.size() + (tipo.isBlank() ?
//                    " JOGADORES MARCARAM MAIS GOLS" :
//                    (" JOGADORES MARCARAM MAIS GOLS POR " + tipo.toUpperCase())) + " ###\n");
//        } else {
//            System.out.print((tipo.isBlank() ? "### JOGADOR COM MAIS GOLS ###" : ("### JOGADOR COM MAIS GOLS POR" + tipo.toUpperCase())) + " ###\n");
//        }
//
//        melhoresJogadores.forEach(System.out::println);
//
//        System.out.print("\n\n");
    }
}