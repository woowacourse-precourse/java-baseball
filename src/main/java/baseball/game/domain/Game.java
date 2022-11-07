package baseball.game.domain;

import java.util.List;

public class Game {
    private final RandomNumber gameNumber;
    private Integer strikeCount;
    private Integer ballCount;
    public void initCount(){
        strikeCount=0;
        ballCount=0;
    }
    public List<Integer> getGameNumber(){
        return gameNumber.getRandomNumber();
    }
    public Integer getStrikeCount(){return strikeCount;}
    public Integer getBallCount() {return ballCount;}
    public void updateStrikeCount(){this.strikeCount++;}
    public void updateBallCount(){this.ballCount++;}

    public Game(RandomNumber gameNumber) {
        this.gameNumber = gameNumber;
        this.strikeCount=0;
        this.ballCount=0;
    }
}
