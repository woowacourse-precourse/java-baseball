package baseball;

public class Result {
    private int strike;
    private int ball;

    public Result(Number computerNumber, Number userNumber) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
    }

    public void print() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    public boolean isCorrect() {
        return this.strike == 3;
    }
}
