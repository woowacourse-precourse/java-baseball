package baseball.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validation {

    public static void IsOnlyNumber(String input) {
        char[] chars = input.toCharArray();
        for (char alphabet : chars) {
            if (Character.isDigit(alphabet) == false)
                throw new IllegalArgumentException("숫자 외의 문자를 입력하셨습니다.");
        }
    }

    public static void IsNumberThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3글자의 숫자입니다.");
        }
    }

    public static void IsRestartOrEnd(String input) {
        if (input.equals("1") == false && input.equals("2") == false) {
            throw new IllegalArgumentException("게임이 끝난뒤에는 1 또는 2의 숫자를 입력해야만 합니다.");
        }
    }

    public static void IsDistinct(String input) {
        List<String> convertCollection = new ArrayList<>(Arrays.asList(input.split("")));

        if (input.length() != convertCollection.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
