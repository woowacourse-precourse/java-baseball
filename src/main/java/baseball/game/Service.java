package baseball.game;

import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final int MAX_LENGTH = 3;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int RE_START = 1;
    private static final int END_GAME = 2;

    public static void startGame(List<Integer> computer) {

        while (true) {
            Parameter.initParam();
            Output.numberInput();

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
        String result = "";

        if (strike != 0 && strike != 3 && ball != 0) {
            result = ball + BALL + " " + strike + STRIKE;
        } else if (strike == 0 && ball != 0) {
            result = ball + BALL;
        } else if (ball == 0 && strike != 3 && strike != 0) {
            result = strike + STRIKE;
        } else if (ball == 0 && strike == 0) {
            result = NOTHING;
        } else if (strike == 3) {
            result = strike + STRIKE;
            flag = true;
        }

        System.out.println(result);
        return flag;
    }

    public static List<Integer> getRandomNum() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean restartCheck(int num) {

        if(num == RE_START) {
            return false;
        }
        if(num == END_GAME) {
            return true;
        }
        else throw new IllegalArgumentException();
    }
}
