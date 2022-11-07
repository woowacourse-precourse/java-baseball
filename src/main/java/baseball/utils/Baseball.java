package baseball.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Baseball {

    private final LinkedHashSet<Integer> baseballNumber;

    public Baseball(LinkedHashSet<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumber() {
        return new ArrayList<>(baseballNumber);
    }
}
