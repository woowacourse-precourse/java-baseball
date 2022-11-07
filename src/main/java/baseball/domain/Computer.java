package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Restart.reStart;

public class Computer {


    public static List randomNum() {

        List<Integer> randomNum;
        randomNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(number)) {
                randomNum.add(number);
            }
            System.out.println("랜덤 num: " + randomNum.get(i));
        }
        System.out.println("랜덤 num: " + randomNum);

        return randomNum;

    }

    public static int ballScore(String userTarget, String[] userNumArr, int i, int ball) {

        for (int j = 0; j < userNumArr.length; j++) {
            if (userTarget.equals(userNumArr[j]) && i != j) {
                ball++;
            }
        }

        return ball;
    }

    public static int strikeScore(String userTarget, String[] userNumArr, int i, int strike) {

        for (int j = 0; j < userNumArr.length; j++) {
            if (userTarget.equals(userNumArr[j]) && i == j) {
                strike++;
            }
        }
        return strike;
    }

    public static boolean score(String userNum, List<Integer> randomNum, String[] userNumArr, boolean result) {
        int ball = 0;
        int strike = 0;
        int nothing = 0;

        for (int i = 0; i < randomNum.size(); i++) {
            String userTarget = String.valueOf(randomNum.get(i)); // int -> string 형변환
            if (userNum.contains(userTarget)) {
                ball = ballScore(userTarget, userNumArr, i, ball);
                strike = strikeScore(userTarget, userNumArr, i, strike);
            } else {
                nothing++;
            }
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reStart();
            result = true;
        } else if (nothing == 3) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return result;
    }
}

