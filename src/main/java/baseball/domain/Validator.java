package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public void isValidate(String number) {
        number = number.trim();
        if (!isNumeric(number)) {
            throw new IllegalArgumentException();
        }

        List<Character> listNumber = convertStringToCharList(number);
        if (listNumber.size() != 3) {
            throw new IllegalArgumentException();
        }

        if (isDuplicate(listNumber)) {
            throw new IllegalArgumentException();
        }

        if (isZero(listNumber)) {
            throw new IllegalArgumentException();
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

    public static List<Character> convertStringToCharList(String str) {
        List<Character> chars = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        return chars;
    }
}
