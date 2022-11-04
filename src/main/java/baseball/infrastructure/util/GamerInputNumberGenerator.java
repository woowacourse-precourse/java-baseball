package baseball.infrastructure.util;

import baseball.domain.ConsoleInString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GamerInputNumberGenerator {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static List<Integer> generator(ConsoleInString stringNumbers) {
        if (!stringValidation(stringNumbers.inputString())) {
            throw new IllegalArgumentException();
        }

        String[] stringArray = splitString(stringNumbers.inputString());

        return stringToListNumber(stringArray);
    }

    private static List<Integer> stringToListNumber(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).boxed()
            .collect(Collectors.toList());
    }

    private static boolean stringValidation(String stringNumbers) {
        if (stringNumbers == null) {
            return false;
        }
        return pattern.matcher(stringNumbers).matches();
    }

    private static String[] splitString(String stringNumber) {
        return stringNumber.split("");
    }
}
