package baseball.game.domain;

public class Game {
    private final RandomNumber gameNumber;
    private Integer strikeCount;
    private Integer ballCount;
    public void initCount(){
        strikeCount=0;
        ballCount=0;
    }
    public RandomNumber getGameNumber(){
        return gameNumber;
    }
    public Integer getStrikeCount(){return strikeCount;}
    public Integer getBallCount() {return ballCount;}

    public Game(RandomNumber gameNumber) {
        this.gameNumber = gameNumber;
        this.strikeCount=0;
        this.ballCount=0;
    }
}
