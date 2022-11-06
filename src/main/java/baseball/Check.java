package baseball;

public class Check {

    private int strike;
    private int ball;

    public Check(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Check checkBallList(BallList computer, BallList user) {
        int strike = 0;
        int ball = 0;

        for (int i=0;i<3;i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        return new Check(strike, ball);
    }

    public String resultMessage() {

        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        } else if (this.strike>0 && this.ball == 0) {
            return this.strike + "스트라이크";
        } else if (this.ball>0 && this.strike == 0) {
            return this.ball + "볼";
        } else {
            return this.ball + "볼" + " " + this.strike + "스트라이크";
        }
    }

    public int result() {
        if (strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        } else {
            return 0;
        }
    }
}
