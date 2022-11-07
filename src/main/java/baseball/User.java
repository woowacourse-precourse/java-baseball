package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {

    private List<Integer> stringToSeparatedIntegerList(String input) throws IllegalArgumentException {
        if (UserInputException.isContainLetter(input)) {
            throw new IllegalArgumentException("문자가 포함되어 있습니다.");
        }

        if (!UserInputException.isInputLength(input, 3)) {
            throw new IllegalArgumentException("입력의 숫자의 길이가 맞지 않습니다.");
        }

        return IntStream.range(0, input.length())
                .map(i -> Character.getNumericValue(input.charAt(i)))
                .boxed()
                .collect(Collectors.toList());
    }

}
