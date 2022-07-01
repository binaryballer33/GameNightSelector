package com.gamenight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {


    static ArrayList<Player> allPlayersArray = CSVParser.getPlayerInfo();
    // use so that I can get player objects into method call's just using their name field
    static Map<String, Player> playersMap;
    static Set<BoardGame> allGamesArray = CSVParser.getGameInfo();

    static Map<String, BoardGame> gamesMap;

    static {
        playersMap = new HashMap<>();
        for (Player player : allPlayersArray) {
            playersMap.put(player.getPlayerName(), player);
        }

        gamesMap = new HashMap<>();
        for (BoardGame game : allGamesArray) {
            gamesMap.put(game.getGameName(), game);
        }
    }

    @Test
    void getPlayerInfoTest() {
        // call the parser for the players csv,
        // test each Player object's Name, Age and Game Type and make sure their values are correct
        for(Player player : allPlayersArray) {
            assertEquals(player.getPlayerName(), playersMap.get(player.getPlayerName()).getPlayerName());
            assertEquals(player.getPlayerAge(), playersMap.get(player.getPlayerName()).getPlayerAge());
            assertEquals(player.getGameType(), playersMap.get(player.getPlayerName()).getGameType());
        }

    }

    @Test
    void getGameInfoTest() {
        for(BoardGame game : allGamesArray) {
            assertEquals(game.getGameName(), gamesMap.get(game.getGameName()).getGameName());
            assertEquals(game.getMinPlayerCount(), gamesMap.get(game.getGameName()).getMinPlayerCount());
            assertEquals(game.getMaxPlayerCount(), gamesMap.get(game.getGameName()).getMaxPlayerCount());
            assertEquals(game.getMinPlayerAge(), gamesMap.get(game.getGameName()).getMinPlayerAge());
            assertEquals(game.getPlayerName(), gamesMap.get(game.getGameName()).getPlayerName());
            assertEquals(game.getGameType(), gamesMap.get(game.getGameName()).getGameType());
        }
    }
}