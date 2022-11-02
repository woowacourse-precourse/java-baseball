package baseball.game.domain;

import java.util.List;

public class Game {
    private RandomNumber gameNumber;
    private Integer strikeCount;
    private Integer ballCount;
    public RandomNumber getGameNumber(){
        return gameNumber;
    }
    public Game(RandomNumber gameNumber) {
        this.gameNumber = gameNumber;
        this.strikeCount=0;
        this.ballCount=0;
    }
}
