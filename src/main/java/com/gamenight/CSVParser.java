package com.gamenight;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CSVParser {
    public static ArrayList<Player> getPlayerInfo() {
        String path = "src/main/resources/Player.csv";
        ArrayList<Player> playersArray = new ArrayList<>();

        try (Reader in = new FileReader(path)) {
            for (CSVRecord row : CSVFormat.EXCEL.parse(in)) {
                if (row.get(0).equals("playerName")) {
                    continue;
                }
                String name = row.get(0);
                int age = Integer.parseInt(row.get(1));
                GameType gameType = GameType.valueOf(row.get(2));
                playersArray.add(new Player(name, age, gameType));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playersArray;
    }

    public static Set<BoardGame> getGameInfo() {
        String path = "src/main/resources/Game.csv";
        // create a set of board games, using set to eliminate possible duplicate board games
        Set<BoardGame> games = new HashSet<>();

        try (Reader in = new FileReader(path)) {
            for (CSVRecord row : CSVFormat.EXCEL.parse(in)) {
                if (row.get(0).equals("playerName")) {
                    continue;
                }
                String playerName = row.get(0);
                String gameName = row.get(1);
                GameType gameType = GameType.valueOf(row.get(2));
                int minPlayerCount = Integer.parseInt(row.get(3));
                int maxPlayerCount = Integer.parseInt(row.get(4));
                int minPlayerAge = Integer.parseInt(row.get(5));

                // add the games to the set
                games.add(new BoardGame(playerName, gameName, gameType, minPlayerCount, maxPlayerCount, minPlayerAge));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }
}
