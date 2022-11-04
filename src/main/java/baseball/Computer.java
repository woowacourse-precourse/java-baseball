package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private static final String NOTHING = "낫싱";
    private static final String CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final List<Integer> computerNumbers;

    public Computer() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public boolean isCorrectAnswer(List<Integer> userNumbers) {
        if (isNothing(userNumbers)) {
            printNothing();
            return false;
        }

        int strike = countStrike(userNumbers);
        int ball = countBall(userNumbers);
        printStrikeAndBall(strike, ball);

        if (strike == 3) {
            printCorrectAnswer();
        }
        return strike == 3;
    }

    private boolean isNothing(List<Integer> userNumbers) {
        for (Integer number : userNumbers) {
            if (computerNumbers.contains(number)) {
                return false;
            }
        }
        return true;
    }

    private int countStrike(List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer userNumber = userNumbers.get(i);

            if (computerNumber.equals(userNumber)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(List<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer userNumber = userNumbers.get(i);

            if (!computerNumber.equals(userNumber) && computerNumbers.contains(userNumber)) {
                ball++;
            }
        }
        return ball;
    }

    private void printNothing() {
        System.out.println(NOTHING);
    }

    private void printCorrectAnswer() {
        System.out.println(CORRECT_ANSWER);
    }

    private void printStrikeAndBall(int strike, int ball) {
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
