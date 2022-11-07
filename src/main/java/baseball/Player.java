package baseball;

import static baseball.utils.Constants.MINUS;
import static baseball.utils.Constants.STRING_ZERO;
import static baseball.utils.Constants.THREE;
import static baseball.utils.ErrorMessages.BETWEEN_ONE_AND_NINE;
import static baseball.utils.ErrorMessages.DUPLICATE_NUMBER;
import static baseball.utils.ErrorMessages.REQUIRE_THREE_DIGIT_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private final List<Integer> numbers;

    private Player(int number) {
        validate(number);
        intToList(number);
        this.numbers = intToList(number);
    }

    public static Player from(int number) {
        return new Player(number);
    }

    private void validate(int number) {
        if (String.valueOf(number).length() != THREE) {
            throw new IllegalArgumentException(REQUIRE_THREE_DIGIT_NUMBER);
        }
        if (isNotBetweenOneAndNine(String.valueOf(number))) {
            throw new IllegalArgumentException(BETWEEN_ONE_AND_NINE);
        }
        if (containsDuplicateNumber(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private boolean isNotBetweenOneAndNine(String string) {
        return string.contains(MINUS) || string.contains(STRING_ZERO);
    }

    private boolean containsDuplicateNumber(int number) {
        Set<Integer> unitNumbers = new HashSet<>();
        while (number > 0) {
            unitNumbers.add(number % 10);
            number /= 10;
        }
        return unitNumbers.size() < THREE;
    }

    private List<Integer> intToList(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
