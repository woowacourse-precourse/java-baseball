package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    static final String OPENING_STR = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_STR = "숫자를 입력해주세요 : ";
    static final String RESTART_ASK_STR = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String CLOSING_STR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String CONTINUE_STR = "1";
    static final String EXIT_STR = "2";
    static final String BALL_STR = "볼 ";
    static final String STRIKE_STR = "스트라이크";
    static final String NOTHING_STR = "낫싱";
    static final int STRIKE_INT = 1;
    static final int NOTHING_INT = -1;
    static final int BALL_INT = 0;
    static final int TARGET_LENGTH = 3;

    static final int MIN_INT = 1;
    static final int MAX_INT = 9;

    public static void main(String[] args) {
        boolean keepPlaying = true;
        System.out.println(OPENING_STR);
        while (keepPlaying) {
            List<Integer> targetNumber = createTargetNumber();
            guessNumber(targetNumber);
            keepPlaying = inputKeepPlaying();
        }
    }

    static List<Integer> createTargetNumber() {
        List<Integer> targetNumber = new ArrayList<>();
        while (targetNumber.size() < TARGET_LENGTH) {
            int newNumber = Randoms.pickNumberInRange(MIN_INT, MAX_INT);
            if (!targetNumber.contains(newNumber)) {
                targetNumber.add(newNumber);
            }
        }
        return targetNumber;
    }

    static void guessNumber(List<Integer> targetNumber) {
        List<Integer> BallStrikeCount = Arrays.asList(0, 0);
        while (BallStrikeCount.get(STRIKE_INT) < TARGET_LENGTH) {
            List<Integer> userNumber = inputUserNumber();
            BallStrikeCount = judgeUserNumber(targetNumber, userNumber);
            printResult(BallStrikeCount);
        }
        System.out.println(CLOSING_STR);
    }

    static List<Integer> inputUserNumber() {
        System.out.print(INPUT_STR);
        String userInput = Console.readLine();
        verifyInput(userInput);
        List<Integer> userNumber = new ArrayList<>();
        for (String numberChar : userInput.split("")) {
            Integer parseInt = Integer.parseInt(numberChar);
            userNumber.add(parseInt);
        }
        return userNumber;
    }

    static void verifyInput(String userInput) {
        String pattern = String.format("^[%d-%d]{%d}$", MIN_INT, MAX_INT, TARGET_LENGTH);
        boolean isNonzeroThreeDigits = Pattern.matches(pattern, userInput);
        if (!isNonzeroThreeDigits) {
            throw new IllegalArgumentException("Input value must be a three-digit natural number : " + userInput);
        } else if (new HashSet<>(Arrays.asList(userInput.split(""))).size() < TARGET_LENGTH) {
            throw new IllegalArgumentException("Each digit of input value should be unique : " + userInput);
        }
    }

    static List<Integer> judgeUserNumber(List<Integer> targetNumber, List<Integer> userNumber) {
        List<Integer> BallStrikeCount = Arrays.asList(0, 0);
        for (int position = 0; position < TARGET_LENGTH; position++) {
            int judgeResult = judgeEachNumber(targetNumber, position, userNumber.get(position));
            if (judgeResult == BALL_INT || judgeResult == STRIKE_INT) {
                BallStrikeCount.set(judgeResult, BallStrikeCount.get(judgeResult) + 1);
            }
        }
        return BallStrikeCount;
    }

    static int judgeEachNumber(List<Integer> targetNumber, int position, int userInt) {
        int judgeResult = NOTHING_INT;
        if (targetNumber.contains(userInt)) {
            if (targetNumber.get(position) == userInt) {
                judgeResult = STRIKE_INT;
            } else {
                judgeResult = BALL_INT;
            }
        }
        return judgeResult;
    }

    static void printResult(List<Integer> ballStrikeCount) {
        String resultString = "";
        int ball = ballStrikeCount.get(BALL_INT);
        int strike = ballStrikeCount.get(STRIKE_INT);

        if (ball > 0) {
            resultString += (ball + BALL_STR);
        }
        if (strike > 0) {
            resultString += (strike + STRIKE_STR);
        }
        if (resultString.equals("")) {
            resultString = NOTHING_STR;
        }
        System.out.println(resultString.trim());
    }

    static boolean inputKeepPlaying() {
        System.out.println(RESTART_ASK_STR);
        String userInput = Console.readLine();
        if (userInput.equals(EXIT_STR)) {
            return false;
        } else if (userInput.equals(CONTINUE_STR)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid input : " + userInput);
        }
    }
}