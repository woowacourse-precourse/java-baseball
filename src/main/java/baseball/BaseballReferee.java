package baseball;

import java.util.List;

public class BaseballReferee {
    private List<Integer> computer;
    private List<Integer> user;

    int strike;
    int ball;

    public BaseballReferee() {
        this.strike = 0;
        this.ball = 0;
    }

    public BaseballReferee(List<Integer> computer, List<Integer> user) {
        this.computer = computer;
        this.user = user;

        ball = this.countBall();
        strike = this.countStrike();

        printResult();
    }

    public void printResult() {
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크");
        System.out.println();
        if (ball == 0 && strike == 0) System.out.println("낫싱");
        if (strike == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean isThreeStrike() {
        if (this.strike == 3) return true;
        return false;
    }

    public int countStrike() {
        for (int i = 0; i < computer.size(); i += 1) {
            if (computer.get(i) == user.get(i)) this.strike += 1;
        }
        return this.strike;
    }

    public int countBall() {
        for (int i = 0; i < computer.size(); i += 1) {
            this.ball += hasBall(i);
        }
        return this.ball;
    }

    private int hasBall(int i) {
        int count = 0;
        for (int j = 0; j < computer.size(); j += 1) {
            if (i == j) continue;
            if (computer.get(i) == user.get(j)) count += 1;
        }
        return count;
    }
}