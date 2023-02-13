package org.example.Database;

import org.example.Models.Cartao;
import org.example.Models.Estatistica;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface IDataReader {
    List<Partida> readMatches() throws IOException;

    List<Cartao> readCards() throws IOException;

    List<Estatistica> readStatistics() throws IOException;

    List<Gol> readGoals() throws IOException;
}

public class DataReader implements IDataReader {
    String matchUrl = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-full.csv";
    String cardsUrl = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-cartoes.csv";
    String statisticsUrl = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-estatisticas-full.csv";
    String goalsUrl = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-gols.csv";

    private ObjectFactory objectFactory = new ObjectFactory();

    public List<Partida> readMatches() {
        List<Partida> matches = new ArrayList<>();
        List<String[]> data = null;

        try {
            URL url = new URL(matchUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = reader.lines()
                    .map(line -> line.split(","))
                    .map(array -> Arrays.stream(array)
                            .map(str -> str.replaceAll("^\"|\"$", ""))
                            .toArray(String[]::new))
                    .collect(Collectors.toList());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data != null) {
            data.remove(0);

            for (String[] match : data) {
                matches.add(objectFactory.createMatch(match));
            }
        }

        return matches;
    }

    public List<Cartao> readCards() {
        List<Cartao> cards = new ArrayList<>();
        List<String[]> data = null;

        try {
            URL url = new URL(cardsUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = reader.lines()
                    .map(line -> line.split(","))
                    .map(array -> Arrays.stream(array)
                            .map(str -> str.replaceAll("^\"|\"$", ""))
                            .toArray(String[]::new))
                    .collect(Collectors.toList());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data != null) {
            data.remove(0);

            for (String[] card : data) {
                cards.add(objectFactory.createCard(card));
            }
        }

        return cards;
    }

    public List<Estatistica> readStatistics() {
        List<Estatistica> statistics = new ArrayList<>();
        List<String[]> data = null;

        try {
            URL url = new URL(statisticsUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = reader.lines()
                    .map(line -> line.split(","))
                    .map(array -> Arrays.stream(array)
                            .map(str -> str.replaceAll("^\"|\"$", ""))
                            .toArray(String[]::new))
                    .collect(Collectors.toList());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data != null) {
            data.remove(0);

            for (String[] statistic : data) {
                statistics.add(objectFactory.createStatistic(statistic));
            }
        }

        return statistics;
    }

    public List<Gol> readGoals() {
        List<Gol> goals = new ArrayList<>();
        List<String[]> data = null;

        try {
            URL url = new URL(goalsUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = reader.lines()
                    .map(line -> line.split(","))
                    .map(array -> Arrays.stream(array)
                            .map(str -> str.replaceAll("^\"|\"$", ""))
                            .toArray(String[]::new))
                    .collect(Collectors.toList());
            reader.close();


        } catch (Exception ex) {
            return goals;
        }

        if (data != null) {
            data.remove(0);

            for (String[] goal : data) {
                goals.add(objectFactory.createGoal(goal));
            }
        }

        return goals;
    }

}
