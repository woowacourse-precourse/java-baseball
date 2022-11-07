package baseball.valid;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputNumberValidator {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final static String invalidLengthMessage = "길이가 " +  NUMBER_LENGTH + "이어야 합니다.";
    private final static String duplicateMessage = "엽력값이 중복되지 않아야 합니다.";
    private final static String numberRangeMessage = MIN_NUMBER + "에서 " + MAX_NUMBER +"사이 범위의 숫자가 입력되어야 합니다.";

    public static void validateFormat(String input) {
        validateLength(input);
        validateDuplicate(input);
        validateNumberRange(input);
    }

    public static void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) throw new IllegalArgumentException(invalidLengthMessage);
    }

    public static void validateDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (set.contains(target)) throw new IllegalArgumentException(duplicateMessage);
            set.add(target);
        }
    }

    public static void validateNumberRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            int targetInt = Character.getNumericValue(target);
            if (targetInt > MAX_NUMBER || targetInt < MIN_NUMBER) throw new IllegalArgumentException(numberRangeMessage);
        }
    }
}