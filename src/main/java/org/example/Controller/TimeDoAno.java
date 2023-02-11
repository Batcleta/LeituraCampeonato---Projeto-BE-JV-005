package org.example.Controller;

import org.example.Models.Partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeDoAno {

    public static void timeDoAno(int ano, List<Partida> partidas) {
        List<Partida> partidasDoAno = partidas.stream().filter(partida -> partida.getData().getYear() == ano).collect(Collectors.toList());

        if (partidasDoAno.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
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
}
