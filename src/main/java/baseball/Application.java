package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    private static final String EXCEPTION_TEXT = "INPUT MUST CONTAIN 3 DIFFERENT DIGITS ONLY";

    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    private static final String MESSAGE_STRIKE = "스트라이크";
    private static final String MESSAGE_BALL = "볼";
    private static final String MESSAGE_NOTHING = "낫싱";
    private static final String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
    private static final String MESSAGE_THREE_STRIKES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MESSAGE_INPUT = "숫자를 입력해주세요 : ";

    private static final String FLAG_RESTART = "1";
    private static final String FLAG_QUIT = "2";

    private static final int DIGIT_RESTRICTION = 3;

    private static String generateComputerNumber() {
        List<String> digitList = new ArrayList<>();

        while (digitList.size() < 3) {
            int randomDigit = pickNumberInRange(1, 9);
            String digitStr = String.valueOf(randomDigit);

            if (!digitList.contains(digitStr)) {
                digitList.add(digitStr);
            }
        }

        String randomNumber = String.join("", digitList);
        return randomNumber;
    }

    private static boolean hasThreeDigits(String input) {
        boolean isValid = true;

        if (input.length() != DIGIT_RESTRICTION) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean allDifferentDigits(String input) {
        boolean isValid = false;
        boolean iterate = true;

        while (iterate) {
            char digitChar = input.charAt(0);
            String digitStr = Character.toString(digitChar);
            input = input.replaceFirst(digitStr, "");

            if (input.length() == 0) {
                iterate = false;
                continue;
            }

            if (!input.contains(digitStr)) {
                isValid = true;
            } else {
                isValid = false;
                iterate = false;
            }
        }

        return isValid;
    }

    private static int countStrikes(String input, String computer) {
        int strike = 0;

        for (int i = 0; i < DIGIT_RESTRICTION; i++) {
            char inputDigit = input.charAt(i);
            char computerDigit = computer.charAt(i);

            if (inputDigit == computerDigit) {
                strike++;
            }
        }

        return strike;
    }

    private static HashMap<String, Integer> getScore(String input, String computer) {
        HashMap<String, Integer> result = new HashMap<>();

        int strike = countStrikes(input, computer);
        int ball = countBalls(input, computer);

        result.put(STRIKE, strike);
        result.put(BALL, ball);

        return result;
    }

    private static int countBalls(String input, String computer) {
        int ball = 0;

        for (int i = 0; i < DIGIT_RESTRICTION; i++) {
            String inputDigit = input.substring(i, i + 1);

            if (computer.contains(inputDigit) && computer.indexOf(inputDigit) != i) {
                ball++;
            }
        }

        return ball;
    }

    private static void selectMessage(HashMap<String, Integer> score) {
        int ball = score.get(BALL);
        int strike = score.get(STRIKE);

        if (strike == 3) {
            System.out.println(strike + MESSAGE_STRIKE);
            System.out.println(MESSAGE_THREE_STRIKES);
            System.out.println(MESSAGE_RESTART_OR_QUIT);
        } else if (ball == 0 && strike == 0) {
            System.out.println(MESSAGE_NOTHING);
        } else {
            System.out.println(ball + MESSAGE_BALL + " " + strike + MESSAGE_STRIKE);
        }
    }

    private static boolean quit(String flag) {
        boolean isDone;

        if (flag.equals(FLAG_QUIT)) {
            isDone = true;
        } else if (flag.equals(FLAG_RESTART)) {
            isDone = false;
        } else {
            throw new IllegalArgumentException("WRONG INPUT");
        }

        return isDone;
    }

    public static void main(String[] args) {
        String computer = "";
        boolean iterate = true;
        int trial = 0;

        while (iterate) {
            if (trial == 0) {
                System.out.println(MESSAGE_START);
                computer = generateComputerNumber();
            }

            System.out.println(MESSAGE_INPUT);
            String input = readLine();

            if (!hasThreeDigits(input) || !allDifferentDigits(input)) {
                IllegalArgumentException e = new IllegalArgumentException(EXCEPTION_TEXT);
                throw e;
            }

            trial++;
            HashMap<String, Integer> score = getScore(input, computer);
            selectMessage(score);

            int strike = score.get(STRIKE);

            if (strike == 3) {
                trial = 0;
                String flag = readLine();
                iterate = !quit(flag);
            }
        }
    }
}
