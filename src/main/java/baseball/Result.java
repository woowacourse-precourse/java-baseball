package baseball;

public class Result {
    int strike;
    int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    private void printResult() {
        String result;
        result = printNothing();
        result += printBall();
        result += printStrike();
        System.out.println(result);
    }

    public String printNothing() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        return "";
    }

    public String printBall() {
        if (ball > 0) {
           return ball + "볼 ";
        }
        return "";
    }

    public String printStrike() {
        String strikeCount;
        if (strike > 0) {
            strikeCount = strike + "스트라이크 ";
            if (strike == 3) {
                return strikeCount + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }
            return strikeCount;
        }
        return "";
    }

    private boolean results() {
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean success() {
        printResult();
        return results();
    }
}
