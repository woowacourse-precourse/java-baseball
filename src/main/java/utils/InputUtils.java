package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtils {
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

    public List<Integer> changeStringInputToList(String input) {
        return Stream.of(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
