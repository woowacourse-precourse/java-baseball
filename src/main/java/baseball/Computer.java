package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;
    private final int numberSize;
    private final int startInclusive;
    private final int endInclusive;

    public Computer(int numberSize, int startInclusive, int endInclusive) {
        numbers = new ArrayList<>();
        this.numberSize = numberSize;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }
}