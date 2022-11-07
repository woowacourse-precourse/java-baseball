package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtils {
    protected static final int BASEBALL_NUMBER_LENGTH = 3;

    public static boolean isDigit(String input) {
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDigitInValidRange(String input) {
        int inputDigit = Integer.parseInt(input);
        return inputDigit == 1 || inputDigit == 2;
    }

    public static List<Integer> changeStringInputToList(String input) {
        return Stream.of(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static boolean isBaseballNumberLength3(String input) {
        return input.length() == BASEBALL_NUMBER_LENGTH;
    }

    public static boolean isNotDuplicatedNumber(String input) {
        List<Integer> baseballNumber = changeStringInputToList(input);
        int deleteDuplicateLength = (int) baseballNumber.stream().distinct().count();
        return deleteDuplicateLength == BASEBALL_NUMBER_LENGTH;
    }

    public static boolean isValidRange(String input) {
        List<Integer> baseballNumber = changeStringInputToList(input);
        int checkNumberRange = (int) baseballNumber.stream()
                .filter(num -> num > 0 && num <= 9)
                .count();

        return checkNumberRange == BASEBALL_NUMBER_LENGTH;
    }
}
