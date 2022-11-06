package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber;
    int ball;
    int strike;

    public void printResult() {
        if (this.strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        } else if (this.strike == 0) {
            System.out.println(this.ball + "볼");
        } else if (this.ball == 0) {
            System.out.println(this.strike + "스트라이크");
        } else {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }

    public void countBall(List<Integer> userInputNumber) {
        int ball = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.contains(userInputNumber.get(i)) && !(computerNumber.get(i).equals(userInputNumber.get(i)))) {
                ball++;
            }
        }
        this.ball = ball;
    }

    public void countStrike(List<Integer> userInputNumber) {
        int strike = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.get(i).equals(userInputNumber.get(i))) {
                strike++;
            }
        }
        this.strike = strike;
    }

    public boolean isAnswer(){
        if(strike == 3) return true;
        else return false;
    }

    public void makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        this.computerNumber = computerNumber;
    }
}
