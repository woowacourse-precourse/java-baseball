package baseball.service;

import static baseball.type.NumberType.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserNumberService {
    private static List<Integer> userNumbers = new ArrayList<>();

    public static List<Integer> generate() {
        initialize();
        String inputNumber = readLine();

        validateDuplicate(inputNumber);
        validateNumberSize(inputNumber);
        validateZeroNumber(inputNumber);

        for (int index = 0; index < NUMBER_SIZE; index++) {
            int numberToInt = inputNumber.charAt(index) - '0';
            userNumbers.add(numberToInt);
        }

        return userNumbers;
    }

    private static void validateDuplicate(String inputNumber) {
        HashSet<Character> numbers = new HashSet<>();

        for (char number : inputNumber.toCharArray()) {
            numbers.add(number);
        }

        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberSize(String inputNumber) {
        int numberSize = inputNumber.length();

        if (numberSize != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateZeroNumber(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalStateException();
        }
    }

    public static void initialize() {
        userNumbers.clear();
    }
}
