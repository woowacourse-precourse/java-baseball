package iosystem;

import java.util.*;

public class TryValidator {

    private TryValidator(){

    }
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEXP = "^[1-9]+$";

    public static void validate(String input) {
        isNumberBetweenOneToNine(input);
        validateNumberLength(input);
        validateDuplicateNumber(input);
    }

    public static void isNumberBetweenOneToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException("1~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.");
        }
    }

    public static void validateNumberLength(String input) {
        if (input.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리 수만 입력할 수 있습니다.");
        }
    }

    public static void validateDuplicateNumber(String input) {
        List<String> characterList = Arrays.asList(input.split(""));
        if (hasDuplicatedDigit(characterList)) {
            throw new IllegalArgumentException("자리수 간 중복된 수를 가질 수 없습니다.");
        }
    }

    private static boolean hasDuplicatedDigit(List<String> characterList) {
        return characterList.size() != characterList.stream().distinct().count();
    }
}
