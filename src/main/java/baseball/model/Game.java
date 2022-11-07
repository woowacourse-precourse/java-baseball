package baseball.model;

import java.util.List;

public class Game {
    public static final int ANSWER_LENGTH = 3;
    private GameState gameState;
    private int ballCount;
    private int strikeCount;
    public enum GameState{
        RUNNING, CLEAR, OVER
    }

    public Game(){
        this.gameState = GameState.RUNNING;
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void countBall(List<Integer> computerNumeralList, List<Integer> userNumeralList){
        int count = 0;
        for (int i = 0; i < ANSWER_LENGTH; i++){
            for (int j = 0; j < ANSWER_LENGTH; j++){
                if (i != j && userNumeralList.get(i) == computerNumeralList.get(j)) count++;
            }
        }
        this.ballCount = count;
    }

    public void countStrike(List<Integer> computerNumeralList, List<Integer> userNumeralList){
        int count = 0;
        for (int i = 0; i < ANSWER_LENGTH; i++){
            if (computerNumeralList.get(i) == userNumeralList.get(i)){
                count++;
            }
        }
        this.strikeCount = count;
    }

    public int getBallCount(){
        return ballCount;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

}
