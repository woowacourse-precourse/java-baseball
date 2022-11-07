package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static final int NUMBER_DIGIT = 3;

    public static void main(String[] args) {
        printStartGameSentence();
    }

    private static void printStartGameSentence() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getComputerPick() {
        List<Integer> numbers = new ArrayList<>();
        int number;
        while (numbers.size() < 3) {
            number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserPick() {
        String input = inputNumber();
        return stringToIntegerList(input);
    }

    private static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    private static List<Integer> stringToIntegerList(String number) {
        return Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateNumber(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException();
        }

        Set<Character> history = new HashSet<>();
        char number;
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            number = input.charAt(i);

            if (history.contains(number)) {
                throw new IllegalArgumentException();
            }
            history.add(number);
        }
    }
}
