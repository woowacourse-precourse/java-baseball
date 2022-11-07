package baseball;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseBallNumber {

    List<Integer> number;
    final static int BASE_BALL_NUMBER_MAX_SIZE = 3;

    public BaseBallNumber(List<Integer> number) {
        if (hasSameNumber(number) || isNotNumberSizeIsThree(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public boolean hasSameNumber(List<Integer> number) {
        long count = number.stream().distinct().count();
        if (count != number.size()) return true;
        return false;
    }

    private boolean isNotNumberSizeIsThree(List<Integer> number) {
        if (number.size() != BASE_BALL_NUMBER_MAX_SIZE) return true;
        return false;
    }

    public List<Integer> getNumber() {
        return number.stream().collect(Collectors.toList());
    }

    public static BaseBallNumber of(List<Integer> numberList) {
        return new BaseBallNumber(numberList);
    }
}
