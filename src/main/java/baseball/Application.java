package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    final static int INPUT_SIZE = 3;
    final static int FLAG_SIZE = 1;
    final static char CONTINUE_GAME = 1;
    final static char EXIT_GAME = 2;

    public static void main(String[] args) {
        startGame();

        List<Integer> answer;
        List<Integer> userInput;
        int flag = CONTINUE_GAME;

        while (flag == CONTINUE_GAME) {
            answer = getAnswer();
            userInput = getUserInput();
            while (!isAnswer(answer, userInput)) {
                userInput = getUserInput();
            }
            flag = getFlag();
        }
    }

    public static Integer getFlag() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Integer.parseInt(isValidFlag(Console.readLine()));
    }

    public static String isValidFlag(String readLine) {
        boolean isFlagValue = (Character.getNumericValue(readLine.charAt(0)) == CONTINUE_GAME
                || Character.getNumericValue(readLine.charAt(0)) == EXIT_GAME);
        boolean isFlagSize = (readLine.length() == FLAG_SIZE);

        if (isFlagValue && isFlagSize) {
            return readLine;
        }
        throw new IllegalArgumentException();
    }

    public static String isValidUserInput(String readLine) {
        boolean isNumeric = Pattern.matches("^[0-9]*$", readLine);
        boolean isInputSize = (readLine.length() == INPUT_SIZE);
        boolean isDifferentEach = ((readLine.charAt(0) != readLine.charAt(1))
                && (readLine.charAt(1) != readLine.charAt(2))
                && (readLine.charAt(2) != readLine.charAt(0)));

        if (isNumeric && isInputSize && isDifferentEach) {
            return readLine;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isAnswer (List<Integer> answer, List<Integer> userInput) {
        int ball = getBall(answer, userInput);
        int strike = getStrike(answer, userInput);

        if (strike == 3) {
            System.out.println(strike + "스트라이크");

            return true;
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");

            return false;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");

            return false;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");

            return false;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");

        return false;
    }

    public static int getBall(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;

        for (int index = 0; index < INPUT_SIZE; index++) {
            if (answer.contains(userInput.get(index)) && !answer.get(index).equals(userInput.get(index))) {
                ball += 1;
            }
        }

        return ball;
    }

    public static int getStrike(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;

        for (int index = 0; index < INPUT_SIZE; index++) {
            if (answer.get(index).equals(userInput.get(index))) {
                strike += 1;
            }
        }

        return strike;
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        return Arrays
                .stream(isValidUserInput(Console.readLine()).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
