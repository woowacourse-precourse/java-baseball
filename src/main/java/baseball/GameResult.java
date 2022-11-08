package baseball;

public class GameResult {
    private int strike;
    private int ball;
    private String gameResultMessage;

    public GameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.equals(BallStatus.STRIKE)) {
            strike++;
        }
        if (ballStatus.equals(BallStatus.BALL)) {
            ball++;
        }
    }

    public void makePrintMessageByGameResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        }
        if (ball > 0) {
            stringBuilder.append(ball).append("볼").append(" ");
        }
        if (strike > 0) {
            stringBuilder.append(strike).append("스트라이크");
        }
        if (strike == 3) {
            stringBuilder.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        this.gameResultMessage = String.valueOf(stringBuilder);
    }

    public void print() {
        System.out.println(gameResultMessage);
    }

    public boolean stop() {
        return strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }
}
