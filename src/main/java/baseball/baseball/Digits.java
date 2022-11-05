package baseball.baseball;

import java.util.List;

public class Digits {
    static public final int DIGIT_COUNT = 3;
    private final List<Integer> digitList;

    public Digits(List<Integer> digitList) {
        validateDigitListSize(digitList);
        assertDigitListRange(digitList);
        assertDistinctDigitList(digitList);

        this.digitList = digitList;
    }

    public List<Integer> getList() {
        return digitList;
    }

    public int get(int idx) {
        return digitList.get(idx);
    }

    private void assertDigitListRange(List<Integer> digitList) {
        digitList.forEach(this::validateDigitRange);
    }

    private void validateDigitRange(int digit) {
        if (!(1 <= digit && digit <= 9)) throw new IllegalArgumentException("숫자는 1~9의 값이여야 합니다.");
    }

    private void validateDigitListSize(List<Integer> digitList) {
        if (digitList.size() != DIGIT_COUNT)
            throw new IllegalArgumentException("숫자의 개수는 항상 " + DIGIT_COUNT + "이여야 합니다.");
    }

    private void assertDistinctDigitList(List<Integer> digitList) {
        int originalSize = digitList.size();
        int distinctSize = (int) digitList.stream().distinct().count();

        if (originalSize != distinctSize)
            throw new IllegalArgumentException("숫자들은 중복되면 안됩니다.");
    }
}
