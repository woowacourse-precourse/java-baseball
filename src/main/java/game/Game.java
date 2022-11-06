package game;

public abstract class Game implements Startable{
    private final String name;
    private final GameStatus gameStatus;

    public Game (String name, GameStatus gameStatus) {
        this.name = name;
        this.gameStatus = gameStatus;
    }

    public String getName() {
        return name;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
