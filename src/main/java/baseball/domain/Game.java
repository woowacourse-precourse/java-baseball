package baseball.domain;

public class Game {
    private int ballCount;
    private int strikeCount;
    private int[] randomNumber;

    public void initGame(){
        ballCount=0;
        strikeCount=0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void addBallCount(){
        ballCount+=1;
    }
    public void addStrikeCount(){
        strikeCount+=1;
    }
}
