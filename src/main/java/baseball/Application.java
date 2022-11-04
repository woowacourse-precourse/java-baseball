package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static int strike;
    private static int ball;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    private static List<Integer> generateComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> readUserNumber() {
        String inputNum = Console.readLine();
        List<String> splittedNum = List.of(inputNum.split(""));
        List<Integer> digits = splittedNum.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return digits;
    }

    private static void validateUserNumber(List<Integer> digits) {
        if (digits.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        HashSet<Integer> nonDuplicateDigits = new HashSet<>(digits);
        if (nonDuplicateDigits.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void countStrikeAndBall(List<Integer> userNumber, List<Integer> computerNumber) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int userDigit = userNumber.get(i);
            int computerDigit = computerNumber.get(i);

            if (userDigit == computerDigit) {
                strike++;
            } else if (computerNumber.contains(userDigit)) {
                ball++;
            }
        }
    }
}
