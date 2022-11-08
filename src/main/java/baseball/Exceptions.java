package baseball;

import java.util.HashSet;

public class Exceptions {
    public static void checkLength(String s) {
        if (s.length() != Application.NUMBER_LENGTH()) {
            throw new IllegalArgumentException("정해진 글자 수가 아닙니다.");
        }
    }

    public static void checkType(String s) {
        try {
            int stringToInteger = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 형태의 입력이 아닙니다.");
        }
    }

    public static void checkDuplication(String s) {
        HashSet<Character> WORD_SET = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (WORD_SET.contains(s.charAt(i))) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }
            WORD_SET.add(s.charAt(i));
        }
    }
}
