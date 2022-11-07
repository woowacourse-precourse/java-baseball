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

        if(quessNumber.equals(Opponent.getNumber(idx))){
            return true;
        }
        return false;
    }
    private boolean isBall(List<Integer> quessNumber, int idx) {
        if(opponentAnswer.contains(quessNumber)){
            return true;
        }
        return false;
    }
    private boolean isNothing() {
        return strike == 0 & ball == 0;
    }

    public boolean isAllStrike(){
        return strike == 3;
    }

    public void CaculateResult(List<Integer> playerAnswer){
        for ( int idx = 0; idx < playerAnswer.size(); idx++ ) {
            if ( isStrike(playerAnswer, idx) ) {
                strike++;
                continue;
            }

            if ( isBall(playerAnswer, idx) ) {
                ball++;
            }
        }
    }
}
