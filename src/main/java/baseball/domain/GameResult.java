package baseball.domain;

public class GameResult {
    int strike;
    int ball;

    public int getStrike() {
        return this.strike;
    }

    public String toString() {
        if (strike == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (0 < ball) {
            result.append(ball).append("볼 ");
        }
        if (0 < strike) {
            result.append(strike).append("스트라이크");
        }
        return result.toString();
    }
}
