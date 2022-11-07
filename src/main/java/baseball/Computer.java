package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> randomNumList = new ArrayList<>();
    int ball = 0, strike = 0;

    public Computer() {
        setRandomNumList();
    }

    public void setRandomNumList() {
        while (randomNumList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }
    }

    public void startMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputMsg() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public boolean gameLogic(List computer, List user) {
        boolean result = false;
        for (int idx = 0; idx < 3; idx++) {
            ballOrStrike(idx, computer, user);
        }
        printResult();
        if (strike == 3) {
            result = true;
        }
        ball = 0;
        strike = 0;
        return result;
    }

    public void ballOrStrike(int idx, List computer, List user) {
        if (computer.contains(user.get(idx))) {
            if (computer.get(idx) == user.get(idx)) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    public void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public List<Integer> getRandomNumList() {
        return randomNumList;
    }
}
