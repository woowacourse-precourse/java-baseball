package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> computer = new ArrayList<>();
    private static int strike = 0;
    private static int ball = 0;

    public Computer() {
        init();
    }

    private void init() {
        this.computer = generateRandomNumber();
    }

    public static List<Integer> generateRandomNumber() {
        computer.clear();
        while(computer.size() < 3) {
            int randomNUmber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNUmber)) {
                computer.add(randomNUmber);
            }
        }
        return computer;
    }

    public static int guessTargetNumber(List<Integer> guessNumber) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < guessNumber.size(); i++) {
            int guessDigit = guessNumber.get(i);
            int targetDigit = computer.get(i);

            if (targetDigit == guessDigit) {
                strike++;
            }
            if (targetDigit != guessDigit && computer.contains(guessDigit)) {
                ball++;
            }
        }
        getResult();
        return strike;
    }

    public static void getResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void setTargetNumber(List<Integer> target) {
        this.computer = target;
    }
}
