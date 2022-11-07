package baseball;

import java.util.List;

public class Referee {
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private List<Integer> opponentAnswer;
    private int strike;
    private int ball;

    public void saveOpponentAnswer(List<Integer> opponentAnswer) {
        this.opponentAnswer = opponentAnswer;
    }
    private boolean isStrike(List<Integer> quessNumber, int idx) {

        if(quessNumber.get(idx)== Opponent.getNumber(opponentAnswer, idx)){
            return true;
        }
        return false;
    }
    private boolean isBall(List<Integer> quessNumber, int idx) {
        if(opponentAnswer.contains(quessNumber.get(idx))){
            return true;
        }
        return false;
    }
    private boolean isNothing() {
        return strike + ball == 0;
    }

    public boolean isAllStrike(){
        return strike == 3;
    }
    private void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public void CaculateResult(List<Integer> playerAnswer){
        initStrikeAndBall();

        for ( int idx = 0; idx < playerAnswer.size(); idx++ ) {
            if ( isStrike(playerAnswer, idx) ) {
                strike++;
                System.out.println("strike"+ strike);
                continue;
            }

            if ( isBall(playerAnswer, idx) ) {
                ball++;
                System.out.println("ball"+ ball);

            }
        }
    }

    public String getResult(){
        if(isNothing()){
            return NOTHING;
        }
        return BallORStrike();
    }

    private String BallORStrike(){
        if(strike == 0){
            return ball+BALL;
        }

        if(ball == 0){
            return strike+STRIKE;
        }

        return ball + BALL + " " + strike + STRIKE;
    }
}
