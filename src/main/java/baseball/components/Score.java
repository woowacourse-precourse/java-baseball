package baseball.components;

public class Score {

    private final int strike;
    private final int ball;

    public Score(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {

        if(ball==0 && strike==0){
            return "낫싱";
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(ball != 0) {
            stringBuilder.append(ball);
            stringBuilder.append("볼 ");
        }
        if(strike != 0) {
            stringBuilder.append(strike);
            stringBuilder.append("스트라이크 ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

}
