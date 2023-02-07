package org.example.Database;

import org.example.Models.Cartao;
import org.example.Models.Estatistica;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ObjectFactory {
    public Partida createMatch(String[] match) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate data = LocalDate.parse(match[2], formatter);
        LocalTime hora = LocalTime.parse(match[3]);

        return new Partida(match[0], match[1], data, hora, match[4], match[5], match[6], match[7], match[8], match[9], match[10], match[11], match[12], match[13], match[14], match[15]);
    }

    public Cartao createCard(String[] match) {
        return new Cartao(match[0], match[1], match[2], match[3], match[4], match[5], match[6], match[7]);
    }

    public Estatistica createStatistic(String[] match) {
        return new Estatistica(match[0], match[1], match[2], match[3], match[4], match[5], match[6], match[7], match[8], match[9], match[10], match[11], match[12]);
    }

    public Gol createGoal(String[] match) {
        return new Gol(match[0], match[1], match[2], match[3], match[4], match[5]);
    }
}
