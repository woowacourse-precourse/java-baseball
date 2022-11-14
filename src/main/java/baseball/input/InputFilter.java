package baseball.input;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InputFilter {

    public static final int INPUT_LENGTH = 3;
    private static final String SPLIT_DELIMETER = "";
    private static final InputReader reader = new InputReader();

    public static String readLine() {
        String input = reader.read();

        return Optional.ofNullable(input)
                .orElseThrow(() -> {throw new IllegalArgumentException("null값이 입력되었습니다.");} );
    }

    public static String[] splitToLetters(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("null값이 입력되었습니다.");
        }
        return input.split(SPLIT_DELIMETER);

    }

    public static List<Integer> convertToNumbers(String[] letters) {
        List<Integer> numbers = Arrays.stream(letters)
                .filter(InputFilter::isNumberNotZero)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkLength(numbers);

        return numbers;
    }

    private static boolean isNumberNotZero(String letter) {
        return letter.matches("^[1-9]+$");
    }

    private static void checkLength(List<Integer> numbers) {
        if (numbers.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException("허용되지 않은 형식의 입력값입니다.");
        }
    }

}
