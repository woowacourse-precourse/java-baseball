package baseball.view;

public class ScoreResultView {
    private static final String NOTHING = "낫싱";
    private static final String BALL_COMMAND = "볼 ";
    private static final String STRIKE_COMMAND = "스트라이크";
    int ballCount;
    int strikeCount;

    public ScoreResultView(){}

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setStrikeCount(int strikeCount){
        this.strikeCount = strikeCount;
    }

    public void getResultOfScores(String result){

    }

    public String makeResultString(){
        return "";
    }

    public boolean isNothing(){
        return ballCount == 0 && strikeCount == 0;
    }

    public String printNothing(){
        return NOTHING;
    }

    public boolean isOnlyBall(){
        return ballCount != 0 && strikeCount == 0;
    }

    public String printOnlyBall(){
        return Integer.toString(ballCount).concat(BALL_COMMAND);
    }

    public boolean isOnlyStrike(){
        return ballCount != 0 && strikeCount == 0;
    }

    public String printOnlyStrike(){
        return Integer.toString(strikeCount).concat(STRIKE_COMMAND);
    }

    public String printBothBallAndStrike(){
        return "";
    }
}
