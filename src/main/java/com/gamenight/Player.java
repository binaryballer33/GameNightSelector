package com.gamenight;

public class Player {
    //Fields
    private String playerName;
    private int playerAge;
    private GameType gameType;

    public Player(String playerName, int playerAge, GameType gameType) {
        setPlayerName(playerName);
        setPlayerAge(playerAge);
        setGameType(gameType);
    }

    // Setters and Getters
    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    private void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public GameType getGameType() {
        return gameType;
    }

    private void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Name: ").append(getPlayerName()).append("\n")
                .append("Age: ").append(getPlayerAge()).append("\n")
                .append("GameType: ").append(getGameType()).append("\n");
        return sb.toString();
    }
}
