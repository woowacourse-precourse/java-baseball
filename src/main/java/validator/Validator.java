package validator;

import java.util.*;

public class Validator {
    private static final String LENGTH_VALIDATION_FAILED = "입력한 숫자의 길이가 3이 아닙니다.";
    private static final String DIGIT_VALIDATION_FAILED = "입력내용은 모두 숫자로 구성되어야 합니다.";
    private static final String DUPLICATION_VALIDATION_FAILED = "입력내용은 서로 다른 3개의 숫자로 구성되어 합니다.";

    public static boolean validateLength(String input, int baseLength) {
        if(input.length() == baseLength)
            return true;
        throw new IllegalArgumentException(LENGTH_VALIDATION_FAILED);
    }

    public static boolean validateEachDigit(String input) {
        char[] digits = input.toCharArray();
        for(char c : digits)
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(DIGIT_VALIDATION_FAILED);
        return true;
    }

    public static boolean validateNoDuplication(String input) {
        Set<Character> digitSet = new HashSet<>();
        for(int i=0 ; i<input.length() ; i++)
            digitSet.add(input.charAt(i));
        if(digitSet.size() != input.length())
            throw new IllegalArgumentException(DUPLICATION_VALIDATION_FAILED);
        return true;
    }
}
