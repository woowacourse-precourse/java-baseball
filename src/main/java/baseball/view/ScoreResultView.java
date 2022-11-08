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

    public void printScore(){
        getResultOfScores(makeResultString());
    }

    private void getResultOfScores(String result){
        System.out.println(result);
    }

    private String makeResultString(){
        if(isNothing()) return printNothing();
        if(isOnlyBall()) return printOnlyBall();
        if(isOnlyStrike()) return printOnlyStrike();
        return printBothBallAndStrike();
    }

    private boolean isNothing(){
        return ballCount == 0 && strikeCount == 0;
    }

    private String printNothing(){
        return NOTHING;
    }

    private boolean isOnlyBall(){
        return ballCount != 0 && strikeCount == 0;
    }

    private String printOnlyBall(){
        return Integer.toString(ballCount).concat(BALL_COMMAND);
    }

    private boolean isOnlyStrike(){
        return ballCount == 0 && strikeCount != 0;
    }

    private String printOnlyStrike(){
        return Integer.toString(strikeCount).concat(STRIKE_COMMAND);
    }

    private String printBothBallAndStrike(){
        return printOnlyBall().concat(printOnlyStrike());
    }
}
