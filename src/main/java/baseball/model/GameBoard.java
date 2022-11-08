package baseball.model;

public class GameBoard {

    private final Strike strike;
    private final Ball ball;

    public GameBoard() {
        strike = new Strike();
        ball = new Ball();
    }

    public void strike() {
        strike.count();
    }

    public void ball() {
        ball.count();
    }

    public boolean isThreeStrike() {
        return strike.isThreeStrike();
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(ball.result()).append(strike.result());
        if (isStrikeOut(sb)) {
            sb.append("낫싱");
        }
        return sb.toString();
    }

    private boolean isStrikeOut(StringBuilder sb) {
        return sb.length() == 0;
    }
}
