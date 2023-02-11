package org.example.Controller;

import org.example.Models.Gol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorComMaisGols {

    public static void jogadorComMaisGols(List<Gol> gols, String tipo) {
        List<Gol> golsPorTipo = gols.stream().filter(gol -> gol.getTipoDeGol().equalsIgnoreCase(tipo)).collect(Collectors.toList());

        if (golsPorTipo.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Integer> golsPorJogadores = new HashMap<>();

        for (Gol gol : golsPorTipo) {
            String jogador = gol.getAtleta();
            if (jogador != null && !jogador.equalsIgnoreCase("-")) {
                golsPorJogadores.put(jogador, golsPorJogadores.getOrDefault(jogador, 0) + 1);
            }
        }

        int maxGoals = 0;
        List<String> melhoresJogadores = new ArrayList<>();

        for (Map.Entry<String, Integer> jogador : golsPorJogadores.entrySet()) {
            if (jogador.getValue() > maxGoals) {
                maxGoals = jogador.getValue();
                melhoresJogadores.clear();
                melhoresJogadores.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " gols.");
            } else if (jogador.getValue() == maxGoals) {
                melhoresJogadores.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " gols.");
            }
        }

        if (melhoresJogadores.size() > 1) {
            System.out.print("### " + melhoresJogadores.size() + (tipo.isBlank() ?
                    " JOGADORES MARCARAM MAIS GOLS" :
                    (" JOGADORES MARCARAM MAIS GOLS POR " + tipo.toUpperCase())) + " ###\n");
        } else {
            System.out.print((tipo.isBlank() ? "### JOGADOR COM MAIS GOLS ###" : ("### JOGADOR COM MAIS GOLS POR" + tipo.toUpperCase())) + " ###\n");
        }

        melhoresJogadores.forEach(System.out::println);

        System.out.print("\n\n");
    }
}