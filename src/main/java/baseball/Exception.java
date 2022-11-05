package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {

    public static void check(String input) throws IllegalArgumentException {
        Set<Character> duplicationCheck = new HashSet<>();
        final int MAX_SIZE = 3;
        final int SIGN = 0;

        if (input.length() != MAX_SIZE) {
            throw new IllegalArgumentException("숫자를 3개 입력하세요");
        }

        if (input.charAt(SIGN) == '-') {
            throw new IllegalArgumentException("양수만 입력하세요");
        }

        for (char individualValue : input.toCharArray()) {
            if (!Character.isDigit(individualValue)) {
                throw new IllegalArgumentException("숫자만 입력하세요");
            }
            duplicationCheck.add(individualValue);
        }

        if (duplicationCheck.size() != MAX_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }

    public static void check(String input, int maxSize) throws IllegalArgumentException {
        Set<Character> duplicationCheck = new HashSet<>();
        final int SIGN = 0;

        if (input.length() != maxSize) {
            throw new IllegalArgumentException("숫자를 " + maxSize + "개 입력하세요");
        }

        if (input.charAt(SIGN) == '-') {
            throw new IllegalArgumentException("양수만 입력하세요");
        }

        for (char individualValue : input.toCharArray()) {
            if (!Character.isDigit(individualValue)) {
                throw new IllegalArgumentException("숫자만 입력하세요");
            }
            duplicationCheck.add(individualValue);
        }

        if (duplicationCheck.size() != maxSize) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }

}
