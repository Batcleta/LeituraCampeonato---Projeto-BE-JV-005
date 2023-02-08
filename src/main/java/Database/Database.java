package Database;

import org.example.Models.Cartao;
import org.example.Models.Estatistica;
import org.example.Models.Gol;
import org.example.Models.Partida;

import java.util.List;

public class Database {
    private DataReader dataReader;
    private static Database instance;
    private List<Partida> matches;
    private List<Cartao> cards;
    private List<Estatistica> statistics;
    private List<Gol> goals;

    private Database() {
        this.dataReader = new DataReader();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void init() {
        matches = dataReader.readMatches();
        cards = dataReader.readCards();
        statistics = dataReader.readStatistics();
        goals = dataReader.readGoals();
    }

    public List<Partida> buscarPartidas() {
        return matches;
    }

    public List<Cartao> buscarCartoes() {
        return cards;
    }

    public List<Estatistica> buscarEstatisticas() {
        return statistics;
    }

    public List<Gol> buscarGols() {
        return goals;
    }


    public Partida buscarPartidaPorId(String matchId) {
        return matches.stream()
                .filter(match -> match.getID().equalsIgnoreCase(matchId))
                .findFirst()
                .orElse(null);
    }

    public Cartao buscarCartaoPorIdDaPartida(String mathId) {
        return cards.stream()
                .filter(card -> card.getPartidaId().equalsIgnoreCase(mathId))
                .findFirst()
                .orElse(null);
    }

    public Estatistica buscarEstatisticaPorIdDaPartida(String mathId) {
        return statistics.stream()
                .filter(statistic -> statistic.getPartidaId().equalsIgnoreCase(mathId))
                .findFirst()
                .orElse(null);
    }

    public Gol buscarGolPorIdDaPartida(String mathId) {
        return goals.stream()
                .filter(goal -> goal.getPartidaId().equalsIgnoreCase(mathId))
                .findFirst()
                .orElse(null);
    }

    public Partida buscarPartidaPorRodada(String rodada) {
        return matches.stream()
                .filter(match -> match.getRodada().equalsIgnoreCase(rodada))
                .findFirst()
                .orElse(null);
    }

    public Cartao buscarCartaoPorRodada(String rodada) {
        return cards.stream()
                .filter(card -> card.getRodada().equalsIgnoreCase(rodada))
                .findFirst()
                .orElse(null);
    }

    public Estatistica buscarEstatisticaPorRodada(String rodada) {
        return statistics.stream()
                .filter(statistic -> statistic.getRodada().equalsIgnoreCase(rodada))
                .findFirst()
                .orElse(null);
    }

    public Gol buscarGolPorRodada(String rodada) {
        return goals.stream()
                .filter(goal -> goal.getRodada().equalsIgnoreCase(rodada))
                .findFirst()
                .orElse(null);
    }

    public void close() {
        instance = null;
    }

}
