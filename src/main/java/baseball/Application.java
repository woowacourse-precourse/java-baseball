package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        startGame();

        List<Integer> answer;
        List<Integer> userInput;
        int flag = 1;

        while (flag == 1) {
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
        boolean isOneOrTwo = (readLine.charAt(0) == '1' || readLine.charAt(0) == '2');
        boolean isOnce = (readLine.length() == 1);

        if (isOneOrTwo && isOnce) {
            return readLine;
        }
        throw new IllegalArgumentException();
    }

    public static String isValidUserInput(String readLine) {
        boolean isNumeric = Pattern.matches("^[0-9]*$", readLine);
        boolean isTriple = (readLine.length() == 3);
        boolean isDifferentEach = ((readLine.charAt(0) != readLine.charAt(1))
                && (readLine.charAt(1) != readLine.charAt(2))
                && (readLine.charAt(2) != readLine.charAt(0)));

        if (isNumeric && isTriple && isDifferentEach) {
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

        for (int index = 0; index < 3; index++) {
            if (answer.contains(userInput.get(index)) && !answer.get(index).equals(userInput.get(index))) {
                ball += 1;
            }
        }

        return ball;
    }

    public static int getStrike(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;

        for (int index = 0; index < 3; index++) {
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

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
