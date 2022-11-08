package baseball;

public class GameManager {

    private GameState gameState;
    public GameManager(){
    }

    public StateEnum run(){ // initialize game state and run the game.
        return StateEnum.REDO;
    }

}
