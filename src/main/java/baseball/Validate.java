package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    public static List<Integer> isNumValid(int num) {
        if (!isThreeLength(num)) {
            throw new IllegalArgumentException("숫자 길이 맞지 않음");
        }
        return isDiffEach(num);
    }

    public static boolean isCommandValid(int num) {
        return 1<= num && num <= 2;
    }

    private static List<Integer> isDiffEach(int num) {
        List<Integer> arr = new ArrayList<>();
        while (num != 0) {
            int digit = num %10;
            if(arr.contains(digit)) throw new IllegalArgumentException("중복된 숫자");
            else arr.add(digit);
            num = num/10;
        }
        return arr;
    }

    private static boolean isThreeLength(int num) {
        return String.valueOf(num).length() == 3;
    }
}
