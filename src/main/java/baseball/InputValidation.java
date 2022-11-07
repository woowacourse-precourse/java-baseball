package baseball;

import java.util.HashMap;
import java.util.Map;

public class InputValidation {
    public void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해야 합니다.");
        }
    }

    public void validateNumberRange(String input) {
        char[] chars = input.toCharArray();

        for (char letter : chars) {
            if (!('1' <= letter && letter <= '9')) {
                throw new IllegalArgumentException("1부터 9까지의 수를 입력해야 합니다.");
            }
        }
    }

    public void validateDuplication(String input) {
        Map<String, Integer> map = new HashMap<>();

        for (String letter : input.split("")) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);

            if (map.get(letter) >= 2) {
                throw new IllegalArgumentException("각 자리의 수가 서로 달라야 합니다.");
            }
        }
    }

    public void validateChoice(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}
