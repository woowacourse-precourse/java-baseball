package baseball;

public class Referee {
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private Opponent opponentNumber;
    private int strike;
    private int ball;

    public void saveAnswer(Opponent opponentNumber) {
        this.opponentNumber = opponentNumber;
    }
    private boolean isStrike(Player quessNumber, int idx) {

        if(quessNumber.equals(Opponent.getNumber(idx))){
            return true;
        }
        return false;
    }


}
