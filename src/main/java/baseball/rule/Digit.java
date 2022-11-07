package baseball.rule;

import java.util.List;

public class Digit {

    public static final int DIGITS = 3;

    private Digit() {
    }

    public static boolean isMatchDigit(List<Integer> inputs) {
        return inputs.size() == DIGITS;
    }
}
