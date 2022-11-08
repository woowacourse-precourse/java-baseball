package baseball.bo;

import baseball.Interfaces.RandomNumber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class UserNumber implements RandomNumber {
    private final List<Integer> userNumbers;

    public UserNumber(String input) {
        validateInput(input);
        this.userNumbers = convertStringToNumbers(input);
    }

    @Override
    public List<Integer> getNumbers() {
        return userNumbers;
    }

    private List<Integer> convertStringToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char numChar : input.toCharArray()) {
            numbers.add(Character.getNumericValue(numChar));
        }
        return numbers;
    }

    private void validateInput(String input) {
        if (!isStringNumberInRange(input, MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE)
                || !haveValidLength(input)
                || !isUniqueChars(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isStringNumberInRange(String input, int start, int end) {
        String range = String.format("^[%d-%d]*$",start, end);

        return (Pattern.matches(range, input) && input != null);
    }

    private boolean haveValidLength(String input) {
        return input.length() == MAX_NUMBER_OF_DIGIT;
    }

    private boolean isUniqueChars(String str) {
        Set<Character> strings = new HashSet<>();
        for (char c : str.toCharArray()) {
            strings.add(c);
        }
        return strings.size() == str.length();
    }

}
