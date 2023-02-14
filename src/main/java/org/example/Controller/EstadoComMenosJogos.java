package org.example.Controller;

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

    }

}
