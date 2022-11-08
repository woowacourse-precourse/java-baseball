package baseball;

import java.util.List;

public class CompareNumber {
    private int strike;
    private int ball;
    private List<Integer> computer;
    private List<Integer> user;

    public CompareNumber() {
    }

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }

    public void setUp(List<Integer> user) {
        this.strike = 0;
        this.ball = 0;
        this.user = user;

    }

    public void isSameNumber() {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public boolean numberToSResult() {
        String answer;
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike != 0 && ball != 0) {
            answer = ball + "볼 " + strike + "스트라이크";
        } else if (strike != 0) {
            answer = strike + "스트라이크";
        } else if (ball != 0) {
            answer = ball + "볼";
        } else {
            answer = "낫싱";
        }
        System.out.println(answer);
        return false;
    }

    public boolean gameRun(List<Integer> user) {
        setUp(user);
        isSameNumber();
        return numberToSResult();
    }
}
