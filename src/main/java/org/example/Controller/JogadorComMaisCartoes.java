package org.example.Controller;

import org.example.Models.Cartao;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JogadorComMaisCartoes {

    public static void JogadorComMaisCartoes(List<Cartao> cartoes, String tipo) {
        List<Cartao> cartaoPorTipo = cartoes.stream().filter(cartao -> cartao.getCartao().equalsIgnoreCase(tipo)).collect(Collectors.toList());

        if (cartaoPorTipo.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Long> cartoesPorJogadores = cartaoPorTipo.stream()
                .filter(cartao -> cartao.getAtleta() != null && !cartao.getAtleta().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        String jogadoresComMaisCartoes = cartoesPorJogadores.entrySet().stream()
                .filter(entry -> entry.getValue() == Collections.max(cartoesPorJogadores.values()))
                .map(entry -> "Jogador: " + entry.getKey() + ", com: " + entry.getValue() + " cartões.")
                .collect(Collectors.joining(", "));

        System.out.println("Jogadores com mais cartões\n" + jogadoresComMaisCartoes);
        System.out.print("\n\n");
    }
}
