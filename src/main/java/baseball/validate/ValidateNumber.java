package baseball.validate;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidateNumber {

    public static void validateLength(int number, Predicate<Integer> p) {
        String s = String.valueOf(number);
        int length = s.length();
        if (!p.test(length)) {
            throw new IllegalStateException("숫자의 자릿수를 확인해주세요");
        }
    }

}
