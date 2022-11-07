package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static boolean isValid(String readLine) {
        boolean isNumeric = Pattern.matches("^[0-9]*$", readLine);
        boolean isTriple = (readLine.length() == 3);

        return (isNumeric && isTriple);
    }

    public static void result(List<Integer> answer, List<Integer> userInput) {
        int ball = getBall(answer, userInput);
        int strike = getStrike(answer, userInput);

        if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else if (strike == 0) {
            System.out.println(ball + "볼");
        }
        else {
            System.out.println("낫싱");
        }
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
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> getUserInput(String readLine) {
        System.out.print("숫자를 입력해주세요 : ");

        return Arrays
                .stream(readLine.split(""))
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

    public static void main(String[] args) {
    }
}
