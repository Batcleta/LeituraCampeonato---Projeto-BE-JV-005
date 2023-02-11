package org.example.Controller;

import org.example.Models.Cartao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorComMaisCartoes {

    public static void JogadorComMaisCartoes(List<Cartao> cartoes, String tipo) {
        List<Cartao> cartaoPorTipo = cartoes.stream().filter(cartao -> cartao.getCartao().equalsIgnoreCase(tipo)).collect(Collectors.toList());

        if (cartaoPorTipo.size() == 0) {
            System.out.println("Não foram encontrados nenhum resultado");
            return;
        }

        Map<String, Integer> cartoesPorJogadores = new HashMap<>();

        for (Cartao cartao : cartaoPorTipo) {
            String jogador = cartao.getAtleta();
            if (jogador != null && !jogador.equalsIgnoreCase("-")) {
                cartoesPorJogadores.put(jogador, cartoesPorJogadores.getOrDefault(jogador, 0) + 1);
            }
        }

        int maxCards = 0;
        List<String> jogadoresComMaisCartoes = new ArrayList<>();

        for (Map.Entry<String, Integer> jogador : cartoesPorJogadores.entrySet()) {
            if (jogador.getValue() > maxCards) {
                maxCards = jogador.getValue();
                jogadoresComMaisCartoes.clear();
                jogadoresComMaisCartoes.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " cartões.");
            } else if (jogador.getValue() == maxCards) {
                jogadoresComMaisCartoes.add("Jogador: " + jogador.getKey() + ", com: " + jogador.getValue() + " cartões.");
            }
        }

        if (jogadoresComMaisCartoes.size() > 1) {
            System.out.print("### " + jogadoresComMaisCartoes.size() + (tipo.isBlank() ?
                    " JOGADORES COM MAIS CARTÕES" :
                    (" JOGADORES COM MAIS CARTÕES " + tipo.toUpperCase())) + " ###\n");
        } else {
            System.out.print((tipo.isBlank() ? "### JOGADOR COM MAIS CARTÕES ###" : ("### JOGADOR COM MAIS CARTÕES POR " + tipo.toUpperCase())) + " ###\n");
        }

        jogadoresComMaisCartoes.forEach(System.out::println);

        System.out.print("\n\n");



    }


}
