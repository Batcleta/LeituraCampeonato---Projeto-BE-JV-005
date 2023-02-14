package org.example.Controller;

import org.example.Models.Partida;

import java.util.*;
import java.util.stream.Collectors;

public class TimeDoAno {

    public static void timeDoAno(int ano, List<Partida> partidas) {
        List<Partida> partidasDoAno = partidas.stream().filter(partida -> partida.getData().getYear() == ano).collect(Collectors.toList());

        if (partidasDoAno.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Long> vitoriasPorTime = partidasDoAno.stream()
                .filter(partida -> partida.getVencedor() != null && !partida.getVencedor().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()));

        String melhoresTimes = vitoriasPorTime.entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.min(vitoriasPorTime.values()))
                .map(entry -> "Time: " + entry.getKey() + ", com: " + entry.getValue() + " vitórias.\n")
                .collect(Collectors.joining(""));

        System.out.println("=== Times com mais vitórias ===\n" + melhoresTimes);
        System.out.print("\n\n");


//        Map<String, Integer> vitoriasPorTime = new HashMap<>();
//
//        for (Partida partida : partidasDoAno) {
//            String vencedor = partida.getVencedor();
//            if (vencedor != null && !vencedor.equalsIgnoreCase("-")) {
//                vitoriasPorTime.put(vencedor, vitoriasPorTime.getOrDefault(vencedor, 0) + 1);
//            }
//        }
//
//        int maxWins = 0;
//        List<String> melhoresTimes = new ArrayList<>();
//
//        for (Map.Entry<String, Integer> time : vitoriasPorTime.entrySet()) {
//            if (time.getValue() > maxWins) {
//                maxWins = time.getValue();
//                melhoresTimes.clear();
//                melhoresTimes.add("Time: " + time.getKey() + ", com: " + time.getValue() + " vitórias.");
//            } else if (time.getValue() == maxWins) {
//                melhoresTimes.add("Time: " + time.getKey() + ", com: " + time.getValue() + " vitórias.");
//            }
//        }
//
//        if (melhoresTimes.size() > 1) {
//            System.out.print("\nFORAM " + melhoresTimes.size() + " TIMES VITORIOSOS\n\n");
//        } else {
//            System.out.print("TIME VITORIOSO\n");
//        }
//
//        melhoresTimes.forEach(System.out::println);
//
//        System.out.print("\n\n");
    }
}
