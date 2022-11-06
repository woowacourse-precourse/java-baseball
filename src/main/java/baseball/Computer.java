package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerNumber;
    int ball;
    int strike;

    public void setStrike(List<Integer> userInputNumber) {
        this.strike = countStrike(userInputNumber);
    }

    public void setBall(List<Integer> userInputNumber) {
        this.ball = countBall(userInputNumber);
    }

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

    public int countBall(List<Integer> userInputNumber) {
        int ball = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.contains(userInputNumber.get(i)) && !(computerNumber.get(i).equals(userInputNumber.get(i)))) {
                ball++;
            }
        }
        return ball;
    }

    public int countStrike(List<Integer> userInputNumber) {
        int strike = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.get(i).equals(userInputNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }


    public boolean isAnswer(){
        if(strike == 3) return true;
        else return false;
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

}
