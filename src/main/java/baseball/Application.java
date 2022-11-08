package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getRandomIntList() {
        List<Integer> randomInt = new ArrayList<>();
        while (randomInt.size() < 3) {
            int tempRan = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(tempRan)) {
                randomInt.add(tempRan);
            }
        }
        return randomInt;
    }

    public static int getInputInt(String input) {
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static void validateInput(String input) {

        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력!");
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '1' || '9' < input.charAt(i)) {
                throw new IllegalArgumentException("잘못된 입력!");
            }
        }

        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                checkCharSame(input.charAt(i), input.charAt(j));
            }
        }
    }

    public static void checkCharSame(char a, char b) {
        if (a == b) {
            throw new IllegalArgumentException("잘못된 입력!");
        }
    }

    public static Grade grading(List<Integer> randomInt, int inputInt) {
        Grade grade = new Grade();
        int now = 2;
        while (inputInt > 0) {
            int digit = inputInt % 10;
            if (digit == randomInt.get(now)) {
                grade.strikePlus();
            } else if (randomInt.contains(digit)) {
                grade.ballPlus();
            }
            inputInt /= 10;
            now--;
        }

        return grade;
    }

    public static String makeGradeMessage(Grade grade) {
        int ball = grade.getBall();
        int strike = grade.getStrike();

        String message = "";
        if (ball != 0) {
            message = message + ball + "볼";
            if (strike != 0) {
                message = message + " " + strike + "스트라이크";
            }
        } else if (strike != 0) {
            message = strike + "스트라이크";
        } else {
            message = "낫싱";
        }
        return message;
    }
}