package baseball.game.domain;

import java.util.List;

public class Game {
    private List<Integer> gameNumber;
    private Integer strikeCount;
    private Integer ballCount;

    public List<Integer> getGameNumber(){
        return gameNumber;
    }

    public Game(List<Integer> gameNumber) {
        this.gameNumber = gameNumber;
        this.strikeCount=0;
        this.ballCount=0;
    }
}
