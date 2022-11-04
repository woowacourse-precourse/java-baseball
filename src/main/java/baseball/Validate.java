package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validate {
    private static final int VALID_LENGTH = 3;

    public static List<Integer> isNumValid(String num) {
        if (!checkNumLength(num)) {
            throw new IllegalArgumentException("숫자 길이 맞지 않음");
        }
        return isDiffEach(num);
    }

    public static boolean isCommandValid(int num) {
        if (num == 1) return true;
        if (num == 2) return false;
        throw new IllegalArgumentException("올바르지 않은 명령어");
    }

    private static List<Integer> isDiffEach(String num) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < VALID_LENGTH; i++) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            if(arr.contains(digit)) throw new IllegalArgumentException("중복된 숫자");
            arr.add(digit);
        }
        return arr;
    }

    private static boolean checkNumLength(String num) {
        return num.length() == VALID_LENGTH;
    }
}
