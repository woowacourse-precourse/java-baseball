package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> randomNumGenerate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean ballStrikeNumCalculate(List<Integer> userNum, List<Integer> computerNum) {
        // 유저의 입력 값을 받아 볼과 스트라이크의 개수를 계산하는 함수
        Boolean result = false;
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNum.get(i) == computerNum.get(i)) {
                strike++;
            } else if (computerNum.contains(userNum.get(i))) {
                ball++;
            }
        }
        if (ball == 0 || strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                result = true;
            }
        } else {
            System.out.println(ball + "볼");
            System.out.println(strike + "스트라이크");
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
