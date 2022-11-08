package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validation {

    public static void validateRestartNumber(String restartNumber) {
        validateDigit(restartNumber);
        validateSize(restartNumber, 1);
        validateRange(restartNumber, "^[1-2]*$");
    }

    public static List<Integer> validateUserNumber(String userNumbers) {
        validateDigit(userNumbers);
        validateSize(userNumbers, 3);
        validateRange(userNumbers, "^[1-9]*$");
        validateDuplication(userNumbers);

        return stringToIntegerList(userNumbers);
    }

    private static void validateRange(String numbers, String regex) {

        if (!Pattern.matches(regex, numbers)) {
            throw new IllegalArgumentException("Number is out of range");
        }
    }

    private static void validateDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            checkDigit(number);
        }
    }

    private static void checkDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException("Number must be digit");
        }
    }


    private static void validateSize(String numbers, int digitSize) {
        if (numbers.length() != digitSize) {
            throw new IllegalArgumentException("Number must be correct-digit size: " + digitSize);
        }
    }

    private static void validateDuplication(String numbers) {
        HashMap<Character, Integer> checkMap = new HashMap<>();

        for (char number : numbers.toCharArray()) {
            checkMap.put(number, checkMap.getOrDefault(number, 0) + 1);
        }

        if (checkMap.containsValue(2) || checkMap.containsValue(3)) {
            throw new IllegalArgumentException("UserNumber has duplicate number");
        }
    }

    private static List<Integer> stringToIntegerList(String numbers) {
        String[] arr = numbers.split("");
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }
}
