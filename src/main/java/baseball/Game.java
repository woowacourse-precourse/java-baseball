package baseball;

import java.util.ArrayList;

public class Game {

    protected boolean nothing = true;

    protected int sameNumber = 0;

    protected int strike = 0;
    protected int ball = 0;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void checkNothing(ArrayList<Integer> computer, ArrayList<Character> user) {

        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i) - '0')) {
                this.nothing = false;
                sameNumber++;
            }
        }

        if (this.nothing) {
            System.out.println("낫싱");
        }
    }

    public void countStrike(ArrayList<Integer> computer, ArrayList<Character> user) {

        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i) - '0') { // 같은 자리에 있는 경우
                this.strike++;
            }
        }
    }

    public void countBall() {
        this.ball = this.sameNumber - this.strike;
    }

    public void printResult() {

        if (this.strike != 0 && this.ball != 0) {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        } else if (this.strike == 0) {
            System.out.println(this.ball + "볼");
        } else if (this.ball == 0) {
            System.out.println(this.strike + "스트라이크");

            if (this.strike == 3) {
                end();
            }

        }

    }

    public void resetCount() {
        this.sameNumber = 0;
        this.ball = 0;
        this.strike = 0;
    }

}
