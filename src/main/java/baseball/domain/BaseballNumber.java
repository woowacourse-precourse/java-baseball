package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {
    private final List<Integer> numbers;
    private static final String VALIDATE_NUMBER_PATTERN = "^[1-9]+$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final char ZERO_CHARACTER = '0';
    public static final int DIGIT = 3;

    private BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumber createByRandom() {
        return new BaseballNumber(generateRandomNumbers());
    }

    public static BaseballNumber createByUserInput(String userInput) throws IllegalArgumentException {
        validateInput(userInput);
        return new BaseballNumber(convertStringToIntegerList(userInput));
    }

    private static void validateInput(String input) {
        if (!input.matches(VALIDATE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("입력된 값에 1~9 외의 값이 포함되어 있습니다.");
        }
        if (input.length() != DIGIT) {
            throw new IllegalArgumentException("입력값의 자릿수가 3이 아닙니다.");
        }
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException("입력된 숫자 중 중복된 숫자가 존재합니다.");
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        return input.chars().boxed().map(num -> num - ZERO_CHARACTER)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}