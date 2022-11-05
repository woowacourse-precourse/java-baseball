package baseball.view;

public class ScoreResultView {
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

    }

    public String printNothing(){
        return "";
    }

    public boolean isOnlyBall(){

    }

    public String printOnlyBall(){
        return "";
    }

    public boolean isOnlyStrike(){
        return false;
    }

    public String printOnlyStrike(){
        return "";
    }

    public String printBothBallAndStrike(){
        return "";
    }
}
