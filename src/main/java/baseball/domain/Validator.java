package baseball.domain;

import baseball.advice.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private final static List<Integer> restartCode = new ArrayList<>(Arrays.asList(1, 2));

    public void isValidate(String number) {
        number = number.trim();
        if (!isNumeric(number)) {
            Exception.numericErrror();
        }

        List<Character> listNumber = convertStringToCharList(number);
        if (listNumber.size() != 3) {
            Exception.sizeEroor();
        }

        if (isDuplicate(listNumber)) {
            Exception.duplicationError();
        }

        if (isZero(listNumber)) {
            Exception.containZeroError();
        }
    }

    private static boolean isZero(List<Character> listNumber) {
        return listNumber.stream().anyMatch(number -> number == '0');
    }

    public boolean isNumeric(String num) {
        try {
            double d = Double.parseDouble(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isDuplicate(List<Character> listNumber) {
        return listNumber.stream().distinct().count() != listNumber.size();
    }

    public void restartValidate(String message) {
        message = message.trim();
        if (message.length() != 1) {
            Exception.sizeEroor();
        }
        if (!isNumeric(message)) {
            Exception.numericErrror();
        }

        int exitNumber = Integer.valueOf(message);
        if (!restartCode.contains(exitNumber)) {
            Exception.restartError();
        }
    }

    public static List<Character> convertStringToCharList(String str) {
        List<Character> chars = str
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        return chars;
    }
}