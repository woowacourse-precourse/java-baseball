package baseball;

public class GuessInfo {
    final private int strike;
    final private int ball;

    public GuessInfo(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GuessInfo) {
            return strike == ((GuessInfo) obj).strike && ball == ((GuessInfo) obj).ball;
        }
        return false;
    }

    public void show() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(String.format("%d볼 ", ball));
        }
        if (strike > 0) {
            result.append(String.format("%d스트라이크", strike));
        }
        System.out.println(result);
    }
}
