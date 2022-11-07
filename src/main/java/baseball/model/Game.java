package baseball.model;

public class Game {
    public static final int ANSWER_LENGTH = 3;
    private GameState gameState;
    public enum GameState{
        RUNNING, OVER
    }

    public Game(){
        this.gameState = GameState.RUNNING;
    }

    public GameState getGameState() {
        return this.gameState;
    }
}
