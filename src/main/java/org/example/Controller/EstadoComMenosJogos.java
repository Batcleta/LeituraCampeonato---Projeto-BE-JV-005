package org.example.Controller;

import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.*;
import java.util.stream.Collectors;

public class EstadoComMenosJogos {

    public static void estadoComMenosJogos(int prtiodoInicial, int periodoFinal, List<Partida> partidas) {
        List<Partida> partidasDoAno = partidas.stream().filter(partida -> {
            int year = partida.getData().getYear();
            return year >= prtiodoInicial && year <= periodoFinal;
        }).collect(Collectors.toList());

        if (partidasDoAno.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Long> jogosPorEstado = partidasDoAno.stream()
                .filter(partida -> partida.getMandanteEstado() != null && !partida.getMandanteEstado().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()));

        String estadosComMenosJogos = jogosPorEstado.entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.min(jogosPorEstado.values()))
                .map(entry -> "Estado: " + entry.getKey() + ", com: " + entry.getValue() + " jogos.\n")
                .collect(Collectors.joining(""));

        System.out.println("=== Estados com menos jogos ===\n" + estadosComMenosJogos);
        System.out.print("\n\n");

//        Map<String, Integer> partidasPorEstado = new HashMap<>();
//
//        for (Partida partida : partidasDoAno) {
//            String estado = partida.getMandanteEstado();
//            if (estado != null && !estado.equalsIgnoreCase("-")) {
//                partidasPorEstado.put(estado, partidasPorEstado.getOrDefault(estado, 0) + 1);
//            }
//        }
//
////        for (Map.Entry<String, Integer> entry : partidasPorEstado.entrySet()) {
////            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
////        }
//
//        int minWins = Integer.MAX_VALUE;
//        List<String> pioresEstados = new ArrayList<>();
//
//        for (Map.Entry<String, Integer> time : partidasPorEstado.entrySet()) {
//            if (time.getValue() < minWins) {
//                minWins = time.getValue();
//                pioresEstados.clear();
//                pioresEstados.add("Estado: " + time.getKey() + ", com: " + time.getValue() + " jogos.");
//            } else if (time.getValue() == minWins) {
//                pioresEstados.add("Estado: " + time.getKey() + ", com: " + time.getValue() + " jogos.");
//            }
//        }
//
//        if (pioresEstados.size() > 1) {
//            System.out.print("\nFORAM " + pioresEstados.size() + " ESTADOS COM MENOS JOGOS\n\n");
//        } else {
//            System.out.print("ESTADO COM MENOS JOGOS\n");
//        }
//
//        pioresEstados.forEach(System.out::println);
//
//        System.out.print("\n\n");
    }

}
