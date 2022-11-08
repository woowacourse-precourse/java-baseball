package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    static void CheckNotThreeLength(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }
    }

    static void CheckNotNumber(String input) {
        for(int i = 0; i < 3; i++) {
            char character = input.charAt(i);
            if ((character < '1') || (character > '9')) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    static void CheckNotRedundant(String input) {
        Set<Character> characterSet = new HashSet<>();
        for(int i = 0; i < 3; i++) {
            Character character = input.charAt(i);
            characterSet.add(character);
        }
        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 세 개의 수를 입력해야 합니다.");
        }
    }
}
