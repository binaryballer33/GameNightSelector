package com.gamenight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.gamenight.GetAGame.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAGameTest {
    ArrayList<Player> playersInAttendanceArray;
    static ArrayList<Player> allPlayersArray = CSVParser.getPlayerInfo();
    // use so that I can get player objects into method call's just using their name field
    static Map<String, Player> playersMap;

    static {
        playersMap = new HashMap<>();
        for (Player player : allPlayersArray) {
            playersMap.put(player.getPlayerName(), player);
        }
    }

    @BeforeEach
    void setUp() {
        // These are the default test Player objects that each method will be testing
        playersInAttendanceArray = new ArrayList<>();
        playersInAttendanceArray.add(playersMap.get("Bill"));
        playersInAttendanceArray.add(playersMap.get("Bob"));
        playersInAttendanceArray.add(playersMap.get("Tim"));
    }

    @Test
    void filterGamesTest() {
        ArrayList<BoardGame> filteredGamesOfPlayersInAttendance = filterGames(playersInAttendanceArray);
        for (BoardGame game : filteredGamesOfPlayersInAttendance) {
            boolean result = game.getGameName().equals("Terraforming-Mars") || game.getGameName().equals("Dune");
            assertTrue(result);
        }
        // add Joe to the array, reinitialize filteredGamesOfPlayersInAttendance and see make sure the array is empty
        // adding Joe make's it so none of the games are playable due to them being filtered out because he's 5yrs old
        playersInAttendanceArray.add(playersMap.get("Joe"));
        filteredGamesOfPlayersInAttendance = filterGames(playersInAttendanceArray);
        assertTrue(filteredGamesOfPlayersInAttendance.isEmpty());
    }

    @Test
    void getPlayerCountInAttendanceTest() {
        // should be equal to size 3
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
        playersInAttendanceArray.add(playersMap.get("Jane"));
        // should now be equal to size 4, I added Jane
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
        // should now be equal to size 3 again, I removed Tim
        playersInAttendanceArray.remove(playersMap.get("Tim"));
        assertEquals(getPlayerCountInAttendance(playersInAttendanceArray), playersInAttendanceArray.size());
    }

    @Test
    void getAgeRestrictionInAttendanceTest() {
        // youngest player is 23 so expected value from getAgeRestrictionInAttendance() should be 23
        int ageRestrictionInAttendance = getAgeRestrictionInAttendance(playersInAttendanceArray);
        assertEquals(23, ageRestrictionInAttendance);

        // try adding a player that is younger than the current players in attendance
        // then reinitialize the age restriction by calling our helper method getAgeRestrictionInAttendance
        // expected value should have changed to the youngest player which is Joe
        playersInAttendanceArray.add(playersMap.get("Joe"));
        ageRestrictionInAttendance = getAgeRestrictionInAttendance(playersInAttendanceArray);
        assertEquals(5, ageRestrictionInAttendance);
    }

    @Test
    void getGameTypePreferenceInAttendanceTest() {
        Set<GameType> gameTypePreferenceInAttendance = getGameTypePreferenceInAttendance(playersInAttendanceArray);
        assertTrue(gameTypePreferenceInAttendance.contains(playersMap.get("Bill").getGameType())); // Bob's game type
        assertTrue(gameTypePreferenceInAttendance.contains(playersMap.get("Bob").getGameType())); // Bill's game type
        assertTrue(gameTypePreferenceInAttendance.contains(playersMap.get("Tim").getGameType())); // Tim's game type
        // add Joe to array, reinitialize Set, check if Joe's Game Type is in the set
        playersInAttendanceArray.add(playersMap.get("Joe"));
        gameTypePreferenceInAttendance = getGameTypePreferenceInAttendance(playersInAttendanceArray);
        assertTrue(gameTypePreferenceInAttendance.contains(playersMap.get("Joe").getGameType())); // Joe's game type
    }

    @Test
    void getPlayerNamesInAttendanceTest() {
        Set<String> playerNamesInAttendanceSet = getPlayerNamesInAttendance(playersInAttendanceArray);
        assertTrue(playerNamesInAttendanceSet.contains(playersMap.get("Bill").getPlayerName()));
        assertTrue(playerNamesInAttendanceSet.contains(playersMap.get("Bob").getPlayerName()));
        assertTrue(playerNamesInAttendanceSet.contains(playersMap.get("Tim").getPlayerName()));
        playerNamesInAttendanceSet.add("Joseph");
        assertTrue(playerNamesInAttendanceSet.contains(playersMap.get("Joseph").getPlayerName()));
    }
}