package baseball.game;

import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public static void startGame(List<Integer> computer) {
        while (true) {
            Parameter.initParam();
            System.out.print("숫자를 입력해주세요 : ");

            String number = Console.readLine();
            Exception.verifyNum(number);

            checkNumber(computer, number);

            int strike = Parameter.getStrike();
            int ball = Parameter.getBall();

            if(Boolean.TRUE.equals(result(strike, ball))) {
                break;
            }
        }
    }

    private static void checkNumber(List<Integer> computer, String number) {
        for(int i = 0; i < number.length(); i++) {

            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (num == computer.get(i)) {
                Parameter.addStrike();
            }
            if (num != computer.get(i) && computer.contains(num) ) {
                Parameter.addBall();
            }
        }
    }

    public static Boolean result(int strike, int ball) {

        boolean flag = false;

        if (strike != 0 && strike != 3 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike != 3 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            flag = true;
        }
        return flag;
    }

    public static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean restartCheck(int num) {

        if(num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        else throw new IllegalArgumentException();
    }
}
