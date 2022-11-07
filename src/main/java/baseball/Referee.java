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
    private boolean isStrike(Player quessNumber, int idx) {

        if(quessNumber.equals(Opponent.getNumber(idx))){
            return true;
        }
        return false;
    }
    private boolean isBall(Player quessNumber, int idx) {
        if(opponentAnswer.contains(quessNumber)){
            return true;
        }
        return false;
    }
}
