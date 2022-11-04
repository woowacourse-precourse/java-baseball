package baseball;

import java.util.List;

public class Digits {
    private final List<Integer> digitList;

    public Digits(List<Integer> digitList) {
        this.digitList = digitList;
    }

    public List<Integer> get() {
        return digitList;
    }
}
