package domain;

public class RoundResult {
    private final Integer ballCount;
    private final Integer strikeCount;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    private RoundResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static RoundResult of(int ballCount, int strikeCount){
        return new RoundResult(ballCount, strikeCount);
    }

    private boolean isOnlyBall(){
        if(!ballCount.equals(0) && strikeCount.equals(0)){
            return true;
        }
        return false;
    }

    private boolean isOnlyStrike(){
        if(!strikeCount.equals(0) && ballCount.equals(0)){
            return true;
        }
        return false;
    }

    private boolean isNothing(){
        if(ballCount.equals(0) && strikeCount.equals(0)){
            return true;
        }
        return false;
    }

    public boolean isWin(){
        if(strikeCount.equals(BaseballNumbers.SIZE)){
            return true;
        }
        return false;
    }

    public String toString(){
        if(isNothing()){
            return NOTHING_MESSAGE;
        }
        if(isOnlyBall()){
            return ballCount + BALL_MESSAGE;
        }
        if(isOnlyStrike()){
            return strikeCount + STRIKE_MESSAGE;
        }
        return String.format("%s"+BALL_MESSAGE+" %s"+STRIKE_MESSAGE, ballCount, strikeCount);
    }
}
