package com.gamenight;

public class BoardGame {
    private String playerName;
    //Fields
    private String gameName;
    private GameType gameType;
    private int minPlayerCount;
    private int maxPlayerCount;
    private int minPlayerAge;

    //Constructors
    public BoardGame(String playerName, String gameName, GameType gameType,
                     int minPlayerCount, int maxPlayerCount, int minPlayerAge) {

        setPlayerName(playerName);
        setGameName(gameName);
        setGameType(gameType);
        setMinPlayerCount(minPlayerCount);
        setMaxPlayerCount(maxPlayerCount);
        setMinPlayerAge(minPlayerAge);
    }

    //Getters & Setters
    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGameName() {
        return gameName;
    }

    private void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public GameType getGameType() {
        return gameType;
    }

    private void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getMinPlayerCount() {
        return minPlayerCount;
    }

    private void setMinPlayerCount(int minPlayerCount) {
        this.minPlayerCount = minPlayerCount;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    private void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    public int getMinPlayerAge() {
        return minPlayerAge;
    }

    private void setMinPlayerAge(int minPlayerAge) {
        this.minPlayerAge = minPlayerAge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Name: ").append(getPlayerName()).append("\n")
                .append("Game Name: ").append(getGameName()).append("\n")
                .append("Game Type: ").append(getGameType()).append("\n")
                .append("Min Player Count: ").append(getMinPlayerCount()).append("\n")
                .append("Max Player Count: ").append(getMaxPlayerCount()).append("\n")
                .append("Min Player Age: ").append(getMinPlayerAge()).append("\n");
        return sb.toString();
    }
}
