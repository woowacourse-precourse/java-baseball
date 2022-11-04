package baseball.validate;

import java.util.LinkedList;
import java.util.function.Predicate;

public class ValidateNumber {

    public static void validateLength(int number, Predicate<Integer> p) {
        String s = String.valueOf(number);
        int length = s.length();
        if (!p.test(length)) {
            throw new IllegalStateException("숫자의 자릿수를 확인해주세요");
        }
    }

    public static void validateOverlap(int number) {
        String[] splitNumber = String.valueOf(number).split("");
        LinkedList<String> linkedList = new LinkedList<>();
        for (String n : splitNumber) {
            linkedList.add(n);
        }

        while (linkedList.size() != 0) {
            String pop = linkedList.pop();
            if (linkedList.contains(pop)) {
                throw new IllegalStateException("각 자리가 중복되지 않는 수를 입력해주세요");
            }
        }

    }

}
