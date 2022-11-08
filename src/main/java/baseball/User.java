package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User implements Number {
    List<Integer> number;

    @Override
    public void create() {
        number = convertInputAsNumber(Console.readLine());
    }

    @Override
    public List<Integer> get() {
        return number;
    }

    public static List<Integer> convertInputAsNumber(String inputNumber) {
        validateNumber(inputNumber);
        return Stream.of(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateNumber (String number) {
        if (!isNumberValidMaxSize(number)) {
            // Game 클래스에서 오류 호출
        }

        if (!isNumberValidUnique(number)) {
            // Game 클래스에서 오류 호출
        }

        if (!isNumberValidRange(number)) {
            // Game 클래스에서 오류 호출
        }
    }

    public static boolean isNumberValidMaxSize(String inputNumber) {
        return inputNumber.length() == MAX_SIZE;
    }

    public static boolean isNumberValidUnique(String inputNumber) {
        long distinctSize = Arrays.stream(inputNumber.split(""))
                .distinct()
                .count();
        return inputNumber.length() == distinctSize;
    }

    public static boolean isNumberValidRange(String inputNumber) {
        try {
            return Stream.of(inputNumber.split(""))
                    .map(Integer::parseInt)
                    .allMatch(number -> number >= START_NUMBER && number <= END_NUMBER);
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
